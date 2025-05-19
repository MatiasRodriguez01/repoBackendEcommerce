package org.example.ecommercebackend;

import jakarta.transaction.Transactional;
import org.example.ecommercebackend.entities.Producto.*;
import org.example.ecommercebackend.repositories.Producto.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.text.SimpleDateFormat;

@SpringBootApplication
public class EcommerceBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceBackendApplication.class, args);
        System.out.println("Servidor iniciando");
    }

//    @Bean
//    @Transactional
//    CommandLineRunner initNuevo(
//            DetalleProductoRepository detalleProductoRepository,
//            ProductoRepository productoRepository,
//            CategoriaRepository categoriaRepository,
//            TallesRepository tallesRepository,
//            DescuentoRepository descuentoRepository,
//            PrecioRepository precioRepository,
//            ImagenProductoRepository imagenProductoRepository) {
//        return args -> {
//
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//            // Categorías
//            Categoria training = Categoria.builder()
//                    .nombre("training")
//                    .categoriaPadre(null)
//                    .build();
//            categoriaRepository.save(training);
//
//            Categoria running = Categoria.builder()
//                    .nombre("running")
//                    .categoriaPadre(null)
//                    .build();
//            categoriaRepository.save(running);
//
//            // Talles
//            Talles talle41 = Talles.builder().talle("41").build();
//            Talles talle39 = Talles.builder().talle("39").build();
//            Talles talleXXL = Talles.builder().talle("XXL").build();
//            Talles talleM = Talles.builder().talle("M").build();
//
//            tallesRepository.save(talle41);
//            tallesRepository.save(talle39);
//            tallesRepository.save(talleXXL);
//            tallesRepository.save(talleM);
//
//
//            // Descuentos
//            Descuento desc1 = Descuento.builder().fechaInicio(sdf.parse("2025-06-01")).fechaFin(sdf.parse("2025-07-01")).build();
//            Descuento desc2 = Descuento.builder().fechaInicio(sdf.parse("2025-07-05")).fechaFin(sdf.parse("2025-08-05")).build();
//            Descuento desc3 = Descuento.builder().fechaInicio(sdf.parse("2025-08-10")).fechaFin(sdf.parse("2025-09-10")).build();
//            Descuento desc4 = Descuento.builder().fechaInicio(sdf.parse("2025-06-15")).fechaFin(sdf.parse("2025-07-20")).build();
//            Descuento desc5 = Descuento.builder().fechaInicio(sdf.parse("2025-07-25")).fechaFin(sdf.parse("2025-08-25")).build();
//            Descuento desc6 = Descuento.builder().fechaInicio(sdf.parse("2025-08-30")).fechaFin(sdf.parse("2025-09-30")).build();
//
//            descuentoRepository.save(desc1);
//            descuentoRepository.save(desc2);
//            descuentoRepository.save(desc3);
//            descuentoRepository.save(desc4);
//            descuentoRepository.save(desc5);
//            descuentoRepository.save(desc6);
//
//            // Precios
//            Precio precio1 = Precio.builder().precioCompra(50000).precioVenta(60000).descuento(desc1).build();
//            Precio precio2 = Precio.builder().precioCompra(52000).precioVenta(63000).descuento(desc2).build();
//            Precio precio3 = Precio.builder().precioCompra(54000).precioVenta(65000).descuento(desc3).build();
//            Precio precio4 = Precio.builder().precioCompra(30000).precioVenta(40000).descuento(desc4).build();
//            Precio precio5 = Precio.builder().precioCompra(32000).precioVenta(42000).descuento(desc5).build();
//            Precio precio6 = Precio.builder().precioCompra(35000).precioVenta(45000).descuento(desc6).build();
//
//            precioRepository.save(precio1);
//            precioRepository.save(precio2);
//            precioRepository.save(precio3);
//            precioRepository.save(precio4);
//            precioRepository.save(precio5);
//            precioRepository.save(precio6);
//
//            // Imágenes
//            ImagenProducto img1 = ImagenProducto.builder().url("https://th.bing.com/th/id/OIP.aAKvsf0isFIqOVqdH_ffNgHaHa?rs=1&pid=ImgDetMain").alt("Imagen 1").build();
//            ImagenProducto img2 = ImagenProducto.builder().url("https://http2.mlstatic.com/D_NQ_NP_989930-MCO26513865735_122017-O.jpg").alt("Imagen 2").build();
//            ImagenProducto img3 = ImagenProducto.builder().url("https://th.bing.com/th/id/OIP.nL_MnvuMvSo9BzTy0Gr1AgHaHa?rs=1&pid=ImgDetMain").alt("Imagen 3").build();
//            ImagenProducto img4 = ImagenProducto.builder().url("https://www.digitalsport.com.ar/files/products/5c9e851d8d702-467487-1200x1200.jpg").alt("Imagen 4").build();
//            ImagenProducto img5 = ImagenProducto.builder().url("https://th.bing.com/th/id/OIP.0cDWHbxHfdSEsCNEAHRa5QHaHa?rs=1&pid=ImgDetMain").alt("Imagen 5").build();
//            ImagenProducto img6 = ImagenProducto.builder().url("https://showsport.vtexassets.com/arquivos/ids/813885/PRN-P1598440--1-.jpg?v=638447428071370000").alt("Imagen 6").build();
//
//            imagenProductoRepository.save(img1);
//            imagenProductoRepository.save(img2);
//            imagenProductoRepository.save(img3);
//            imagenProductoRepository.save(img4);
//            imagenProductoRepository.save(img5);
//            imagenProductoRepository.save(img6);
//
//            // DetalleProductos y Productos
//            DetalleProducto det1 = DetalleProducto.builder().stock(5).color("rojo").estado(true).precio(precio1).imagenProducto(img1).build();
//            det1.getTallesDetalleProductos().add(talle41);
//            detalleProductoRepository.save(det1);
//
//            Producto prod1 = Producto.builder().nombre("Zapatilla Training 1").tipoProducto(TipoProducto.ZAPATILLA).seccion(Seccion.MASCULINO).categoria(training).build();
//            prod1.addDetalleProducto(det1);
//            productoRepository.save(prod1);
//
//            DetalleProducto det2 = DetalleProducto.builder().stock(4).color("azul").estado(true).precio(precio2).imagenProducto(img2).build();
//            det2.getTallesDetalleProductos().add(talle39);
//            detalleProductoRepository.save(det2);
//
//            Producto prod2 = Producto.builder().nombre("Zapatilla Running 2").tipoProducto(TipoProducto.ZAPATILLA).seccion(Seccion.FEMENINO).categoria(running).build();
//            prod2.addDetalleProducto(det2);
//            productoRepository.save(prod2);
//
//            DetalleProducto det3 = DetalleProducto.builder().stock(6).color("negro").estado(true).precio(precio3).imagenProducto(img3).build();
//            det3.getTallesDetalleProductos().add(talle41);
//            detalleProductoRepository.save(det3);
//
//            Producto prod3 = Producto.builder().nombre("Zapatilla Training 3").tipoProducto(TipoProducto.ZAPATILLA).seccion(Seccion.MASCULINO).categoria(training).build();
//            prod3.addDetalleProducto(det3);
//            productoRepository.save(prod3);
//
//            DetalleProducto det4 = DetalleProducto.builder().stock(7).color("verde").estado(true).precio(precio4).imagenProducto(img4).build();
//            det4.getTallesDetalleProductos().add(talleXXL);
//            detalleProductoRepository.save(det4);
//
//            Producto prod4 = Producto.builder().nombre("Remera Running 4").tipoProducto(TipoProducto.ROPA).seccion(Seccion.FEMENINO).categoria(running).build();
//            prod4.addDetalleProducto(det4);
//            productoRepository.save(prod4);
//
//            DetalleProducto det5 = DetalleProducto.builder().stock(8).color("blanco").estado(true).precio(precio5).imagenProducto(img5).build();
//            det5.getTallesDetalleProductos().add(talleM);
//            detalleProductoRepository.save(det5);
//
//            Producto prod5 = Producto.builder().nombre("Camiseta Training 5").tipoProducto(TipoProducto.ROPA).seccion(Seccion.MASCULINO).categoria(training).build();
//            prod5.addDetalleProducto(det5);
//            productoRepository.save(prod5);
//
//            DetalleProducto det6 = DetalleProducto.builder().stock(9).color("gris").estado(true).precio(precio6).imagenProducto(img6).build();
//            det6.getTallesDetalleProductos().add(talleXXL);
//            detalleProductoRepository.save(det6);
//
//            Producto prod6 = Producto.builder().nombre("Remera Running 6").tipoProducto(TipoProducto.ROPA).seccion(Seccion.FEMENINO).categoria(running).build();
//            prod6.addDetalleProducto(det6);
//            productoRepository.save(prod6);
//
//            // Asignar productos a categorías
//            training.addProducto(prod1);
//            training.addProducto(prod3);
//            training.addProducto(prod5);
//            categoriaRepository.save(training);
//
//            running.addProducto(prod2);
//            running.addProducto(prod4);
//            running.addProducto(prod6);
//            categoriaRepository.save(running);
//        };
//    }

}