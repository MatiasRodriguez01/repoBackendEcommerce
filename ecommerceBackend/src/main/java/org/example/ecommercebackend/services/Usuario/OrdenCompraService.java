package org.example.ecommercebackend.services.Usuario;

import jakarta.transaction.Transactional;
import org.example.ecommercebackend.entities.Producto.DetalleProducto;
import org.example.ecommercebackend.entities.Usuario.OrdenCompra;
import org.example.ecommercebackend.repositories.Producto.DetalleProductoRepository;
import org.example.ecommercebackend.repositories.Usuario.OrdenCompraRepository;
import org.example.ecommercebackend.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdenCompraService extends BaseService<OrdenCompra, Long> {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    @Autowired
    private DetalleProductoRepository detalleProductoRepository;

    public OrdenCompraService(OrdenCompraRepository ordenCompraRepository, DetalleProductoRepository detalleProductoRepository) {
        super(ordenCompraRepository);
        this.detalleProductoRepository = detalleProductoRepository;
        this.ordenCompraRepository = ordenCompraRepository;
    }

    @Transactional
    public OrdenCompra generarOrdenCompra(List<Long> detalleProdId) throws Exception {
        List<DetalleProducto> prod = new ArrayList<>();
        Double precioTotal = 0.0;
        System.out.println(detalleProdId);
        for (Long l : detalleProdId) {
            DetalleProducto d = detalleProductoRepository.findById(l)
                    .orElseThrow(() -> new Exception("No se encontro el detalle"));
            prod.add(d);
        }

        for (DetalleProducto d: prod) {
            precioTotal += d.getPrecio().getPrecioVenta();
        }
        OrdenCompra ordenCompra = OrdenCompra.builder()
                .total(precioTotal)
                .fechaCompra(LocalDate.from(LocalDateTime.now()))
                .detallesProductos(prod)
                .build();


        return ordenCompraRepository.save(ordenCompra);
    }
}
