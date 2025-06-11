package org.example.ecommercebackend.controllers;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.*;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.resources.preference.Preference;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import org.example.ecommercebackend.entities.Usuario.OrdenCompra;
import org.example.ecommercebackend.entities.Producto.DetalleProducto;
import org.example.ecommercebackend.services.Usuario.OrdenCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/pay")
@RequiredArgsConstructor
public class MercadoPagoController {

    @Autowired
    private OrdenCompraService ordenCompraService;


    @Value("${mercadopago.access.token}")
    private String mercadoPagoAccessToken;

    @PostMapping("/mp")
    @CrossOrigin("*")
    public ResponseEntity<String> mp(@RequestBody Map<String, List<Long>> body) throws Exception{
        List<Long> ids = body.get("detallesIds");
        List<Long> cantidadesLong = body.get("cantidades");

        List<Integer> cantidades = cantidadesLong.stream()
                .map(Long::intValue)
                .toList();

        MercadoPagoConfig.setAccessToken(mercadoPagoAccessToken);
        List<PreferenceItemRequest> items = new ArrayList<>();

        OrdenCompra ordenCompra = ordenCompraService.generarOrdenCompra(ids);

        int i = 0;
        for (DetalleProducto detalle : ordenCompra.getDetallesProductos()) {
            int cantidad = cantidades.get(i);
            Double precioFinal = detalle.getPrecio().getPrecioVenta();
            PreferenceItemRequest item = PreferenceItemRequest.builder()
                    .id(detalle.getId().toString())
                    .title(detalle.getProducto().getNombre())
                    .quantity(cantidad)
                    .currencyId("ARS")
                    .unitPrice(BigDecimal.valueOf(precioFinal))
                    .build();
            items.add(item);
            i++;
        }

        List<PreferencePaymentTypeRequest> excludedPaymentTypes = new ArrayList<>();
        excludedPaymentTypes.add(PreferencePaymentTypeRequest.builder().id("ticket").build());


        PreferencePaymentMethodsRequest paymentMethods = PreferencePaymentMethodsRequest.builder()
                .excludedPaymentTypes(excludedPaymentTypes)
                .installments(1)
                .build();


        PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                .items(items)
                .paymentMethods(paymentMethods)
                .build();

        PreferenceClient client = new PreferenceClient();
        try {
            Preference preference = client.create(preferenceRequest);
            String prefId = preference.getId();
            System.out.println("URL de pago: " + preference.getInitPoint());
            return ResponseEntity.status(HttpStatus.OK).body("{\"preferenceId\":\"" + prefId + "\"}");
        } catch (MPApiException e) {
            System.err.println("MPApiException al crear preferencia:");
            System.err.println("Código de estado HTTP: " + e.getStatusCode());

            String contenido = e.getApiResponse().getContent();
            System.err.println("Respuesta detallada de la API: " + contenido); // ✅ AQUÍ ESTÁ EL DETALLE IMPORTANTE

            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"Fallo al generar preferencia de pago - Código: " + e.getStatusCode() + "\"}");
        } catch (Exception e) {
            System.err.println("Error inesperado:");
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"Error inesperado al generar preferencia de pago\"}");
        }
    }
}
