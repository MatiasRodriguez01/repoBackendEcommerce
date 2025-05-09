package org.example.ecommercebackend;

import jakarta.transaction.Transactional;
import org.example.ecommercebackend.entities.Producto.*;
import org.example.ecommercebackend.repositories.Producto.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.util.Date;

@SpringBootApplication
public class EcommerceBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceBackendApplication.class, args);
        System.out.println("Servidor iniciando");
    }

    @Bean
    @Transactional
    CommandLineRunner init(
            CategoriaRepository categoriaRepository,
            ProductoRepository productoRepository,
            DescuentoRepository descuentoRepository,
            PrecioRepository precioRepository,
            TallesRepository tallesRepository,
            ImagenProductoRepository imagenProductoRepository,
            DetalleProductoRepository detalleProductoRepository
    ) {
        return args -> {
            // 1) Categorías
            Categoria deportes = Categoria.builder()
                    .nombre("Deportes")
                    .categoriaPadre(null)
                    .build();
            categoriaRepository.save(deportes);

            Categoria urbano = Categoria.builder()
                    .nombre("Urbano")
                    .categoriaPadre(null)
                    .build();
            categoriaRepository.save(urbano);

            // 2) Productos
            Producto camiseta = Producto.builder()
                    .nombre("Camiseta de Fútbol")
                    .categoria(deportes)
                    .tipoProducto(TipoProducto.ROPA)
                    .sexo("Femenino")
                    .build();
            productoRepository.save(camiseta);

            Producto zapatillaDeportiva = Producto.builder()
                    .nombre("Zapatilla Deportiva")
                    .categoria(deportes)
                    .tipoProducto(TipoProducto.ZAPATILLA)
                    .sexo("Unisex")
                    .build();
            productoRepository.save(zapatillaDeportiva);

            deportes.addProducto(camiseta);
            deportes.addProducto(zapatillaDeportiva);
            categoriaRepository.save(deportes);

            Producto zapatillaUrbana = Producto.builder()
                    .nombre("Zapatilla Urbana")
                    .categoria(urbano)
                    .tipoProducto(TipoProducto.ZAPATILLA)
                    .sexo("Masculino")
                    .build();
            productoRepository.save(zapatillaUrbana);

            Producto remeraUrbana = Producto.builder()
                    .nombre("Remera Urbana")
                    .categoria(urbano)
                    .tipoProducto(TipoProducto.ROPA)
                    .sexo("Unisex")
                    .build();
            productoRepository.save(remeraUrbana);

            urbano.addProducto(zapatillaUrbana);
            urbano.addProducto(remeraUrbana);
            categoriaRepository.save(urbano);

            // 3) Descuento
            Descuento descuento10 = new Descuento();
            descuento10.setFechaInicio(Date.from(Instant.now()));
            descuento10.setFechaFin(Date.from(Instant.now().plusSeconds(7 * 24 * 3600)));
            descuentoRepository.save(descuento10);

            // 4) Precios
            Precio precioCamiseta = new Precio();
            precioCamiseta.setPrecioCompra(800);
            precioCamiseta.setPrecioVenta(1200);
            precioCamiseta.setDescuento(descuento10);
            precioRepository.save(precioCamiseta);

            Precio precioZapaDep = new Precio();
            precioZapaDep.setPrecioCompra(1000);
            precioZapaDep.setPrecioVenta(1500);
            precioZapaDep.setDescuento(descuento10);
            precioRepository.save(precioZapaDep);

            Precio precioRemera = new Precio();
            precioRemera.setPrecioCompra(500);
            precioRemera.setPrecioVenta(800);
            precioRemera.setDescuento(descuento10);
            precioRepository.save(precioRemera);

            // 5) Imágenes (URLs antiguas para pruebas)
            ImagenProducto imgCamiseta = ImagenProducto.builder()
                    .url("src/Imagenes/imagenPrincipalMujer.avif")
                    .alt("Imagen de camiseta de fútbol")
                    .build();
            imagenProductoRepository.save(imgCamiseta);

            ImagenProducto imgZapaDep = ImagenProducto.builder()
                    .url("src/Imagenes/imagenPrincipalHombre.avif")
                    .alt("Imagen de zapatilla deportiva")
                    .build();
            imagenProductoRepository.save(imgZapaDep);

            ImagenProducto imgRemera = ImagenProducto.builder()
                    .url("src/Imagenes/imagenPrincipalMujer.avif")
                    .alt("Imagen de remera urbana")
                    .build();
            imagenProductoRepository.save(imgRemera);

            // 6) Talles
            Talles talle42 = Talles.builder()
                    .talle("42")
                    .build();
            tallesRepository.save(talle42);

            Talles talle45 = Talles.builder()
                    .talle("45")
                    .build();
            tallesRepository.save(talle45);

            // 7) DetalleProductos
            DetalleProducto detCamiseta = DetalleProducto.builder()
                    .talledetalleProductos(talle42)
                    .producto(camiseta)
                    .precio(precioCamiseta)
                    .color("Blanco")
                    .estado(true)
                    .stock(200)
                    .ImagenProducto(imgCamiseta)
                    .build();
            detalleProductoRepository.save(detCamiseta);
            talle42.addDetalleProducto(detCamiseta);

            DetalleProducto detZapaDep = DetalleProducto.builder()
                    .talledetalleProductos(talle45)
                    .producto(zapatillaDeportiva)
                    .precio(precioZapaDep)
                    .color("Negro")
                    .estado(true)
                    .stock(150)
                    .ImagenProducto(imgZapaDep)
                    .build();
            detalleProductoRepository.save(detZapaDep);
            talle45.addDetalleProducto(detZapaDep);

            DetalleProducto detRemera = DetalleProducto.builder()
                    .talledetalleProductos(talle42)
                    .producto(remeraUrbana)
                    .precio(precioRemera)
                    .color("Gris")
                    .estado(true)
                    .stock(300)
                    .ImagenProducto(imgRemera)
                    .build();
            detalleProductoRepository.save(detRemera);
            talle42.addDetalleProducto(detRemera);

            // actualizar talles con los detalles asociados
            tallesRepository.save(talle42);
            tallesRepository.save(talle45);
        };
    }
}

