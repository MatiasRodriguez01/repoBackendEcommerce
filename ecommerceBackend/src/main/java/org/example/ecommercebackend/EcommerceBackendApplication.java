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

    @Bean
    @Transactional
    CommandLineRunner init(DetalleProductoRepository detalleProductoRepository,
                           ProductoRepository productoRepository,
                           CategoriaRepository categoriaRepository,
                           TallesRepository tallesRepository,
                           DescuentoRepository descuentoRepository,
                           PrecioRepository precioRepository,
                           ImagenProductoRepository imagenProductoRepository) {
        return args -> {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            // descuentos:
            Descuento descuento1 = Descuento.builder().
                    fechaInicio(sdf.parse("2025-05-01")).
                    fechaFin(sdf.parse("2025-08-01")).
                    porcentaje(0.15)
                    .build();
            descuentoRepository.save(descuento1);

            Descuento descuento2 = Descuento.builder().
                    fechaInicio(sdf.parse("2025-08-12")).
                    fechaFin(sdf.parse("2025-10-29")).
                    build();
            descuentoRepository.save(descuento2);

            Descuento descuento3 = Descuento.builder().
                    fechaInicio(sdf.parse("2025-09-15")).
                    fechaFin(sdf.parse("2025-09-20")).
                    build();
            descuentoRepository.save(descuento3);

            Descuento descuento4 = Descuento.builder().
                    fechaInicio(sdf.parse("2025-09-15")).
                    fechaFin(sdf.parse("2025-09-20")).
                    build();
            descuentoRepository.save(descuento4);

            // Precios:
            Precio precio1 = Precio.builder().
                    precioCompra(56000).
                    precioVenta(65000).
                    descuento(descuento1).
                    build();
            precioRepository.save(precio1);

            Precio precio2 = Precio.builder().
                    precioCompra(76000).
                    precioVenta(90000).
                    descuento(descuento2).
                    build();
            precioRepository.save(precio2);

            Precio precio3 = Precio.builder().
                    precioCompra(50000).
                    precioVenta(70000).
                    descuento(descuento3).
                    build();
            precioRepository.save(precio3);

            Precio precio4 = Precio.builder().
                    precioCompra(79000).
                    precioVenta(81000).
                    descuento(descuento4).
                    build();
            precioRepository.save(precio4);

            // imagenes:
            ImagenProducto imagen1 = ImagenProducto.builder().
                    url("https://i.pinimg.com/736x/2b/8c/11/2b8c111e571a104592c8b756ecfccce3.jpg").
                    alt("Zapatillas urbanas").
                    build();
            imagenProductoRepository.save(imagen1);

            ImagenProducto imagen2 = ImagenProducto.builder().
                    url("https://img.fantaskycdn.com/f78015538f96c218b5fb5ab45fa34fe3.jpeg").
                    alt("Zapatillas deportivas").
                    build();
            imagenProductoRepository.save(imagen2);

            ImagenProducto imagen3 = ImagenProducto.builder().
                    url("https://i.pinimg.com/736x/3e/ab/bd/3eabbd4a90e0b4154c16e30ac08ea35f.jpg").
                    alt("Remera deportiva").
                    build();
            imagenProductoRepository.save(imagen3);

            ImagenProducto imagen4 = ImagenProducto.builder().
                    url("https://i.pinimg.com/736x/18/99/9d/18999d50afe296b8fc0a5a14dfc743de.jpg").
                    alt("Remera Urbana").
                    build();
            imagenProductoRepository.save(imagen4);

            //

            // talles
            Talles talle1 = Talles.builder().
                    talle("42").
                    build();
            tallesRepository.save(talle1);

            Talles talle2 = Talles.builder().
                    talle("XL").
                    build();
            tallesRepository.save(talle2);

            Talles talle3 = Talles.builder().
                    talle("40").
                    build();
            tallesRepository.save(talle3);

            Talles talle4 = Talles.builder().
                    talle("L").
                    build();
            tallesRepository.save(talle4);

            // detalle de ropa deportiva
            DetalleProducto detalle1 = DetalleProducto.builder().
                    stock(6).
                    color("rojo").
                    estado(true).
                    build();
            detalle1.getTallesDetalleProductos().add(talle1);
            detalle1.getTallesDetalleProductos().add(talle3);
            detalle1.setPrecio(precio1);
            detalle1.setImagenProducto(imagen1);
            detalleProductoRepository.saveAndFlush(detalle1);


            DetalleProducto detalle2 = DetalleProducto.builder().
                    stock(5).
                    color("azul").
                    estado(true).
                    imagenProducto(imagen3).
                    build();
            detalle2.getTallesDetalleProductos().add(talle2);
            detalle2.getTallesDetalleProductos().add(talle4);
            detalle2.setPrecio(precio2);
            detalle2.setImagenProducto(imagen3);
            detalleProductoRepository.saveAndFlush(detalle2);

            // detalle de ropa urbana

            // detalle de ropa deportiva
            DetalleProducto detalle3 = DetalleProducto.builder().
                    stock(6).
                    color("rojo").
                    estado(true).
                    build();
            detalle3.getTallesDetalleProductos().add(talle1);
            detalle3.getTallesDetalleProductos().add(talle3);
            detalle3.setPrecio(precio3);
            detalle3.setImagenProducto(imagen2);
            detalleProductoRepository.saveAndFlush(detalle3);

            DetalleProducto detalle4 = DetalleProducto.builder().
                    stock(8).
                    color("azul").
                    estado(true).
                    build();
            detalle4.getTallesDetalleProductos().add(talle2);
            detalle4.getTallesDetalleProductos().add(talle4);
            detalle4.setPrecio(precio4);
            detalle4.setImagenProducto(imagen4);
            detalleProductoRepository.saveAndFlush(detalle4);

            //
            Categoria cate1 = Categoria.builder().
                    nombre("deportes").
                    categoriaPadre(null).
                    build();
            categoriaRepository.save(cate1);

            Categoria cate2 = Categoria.builder().
                    nombre("urbano").
                    categoriaPadre(null).
                    build();
            categoriaRepository.save(cate2);

            Producto producto1 = Producto.builder().
                    nombre("camiseta de futbol").
                    tipoProducto(TipoProducto.ROPA).
                    sexo("femenino").
                    build();
            producto1.addDetalleProducto(detalle3);
            productoRepository.saveAndFlush(producto1);

            Producto producto2 = Producto.builder().
                    nombre("zapatilla depo  rtivas").
                    tipoProducto(TipoProducto.ZAPATILLA).
                    sexo("femenino").
                    build();
            producto2.setCategoria(cate1);
            producto2.addDetalleProducto(detalle1);
            productoRepository.save(producto2);

            cate1.addProducto(producto1);
            cate1.addProducto(producto2);
            categoriaRepository.saveAndFlush(cate1);


            Producto producto3 = Producto.builder().
                    nombre("zapatilla urbanas").
                    tipoProducto(TipoProducto.ZAPATILLA).
                    sexo("femenino").
                    build();
            producto3.setCategoria(cate2);
            producto3.addDetalleProducto(detalle2);
            productoRepository.save(producto3);


            Producto producto4 = Producto.builder().
                    nombre("remera urbana").
                    tipoProducto(TipoProducto.ZAPATILLA).
                    sexo("masculino").
                    build();
            producto4.setCategoria(cate2);
            producto4.addDetalleProducto(detalle4);
            productoRepository.save(producto4);


            cate2.addProducto(producto3);
            cate2.addProducto(producto4);
            categoriaRepository.saveAndFlush(cate2);


        };
    }


}