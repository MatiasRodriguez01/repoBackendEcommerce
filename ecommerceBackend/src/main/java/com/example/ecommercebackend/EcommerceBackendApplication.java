package org.example.ecommercebackend;

import jakarta.transaction.Transactional;
import org.example.ecommercebackend.entities.Producto.Categoria;
import org.example.ecommercebackend.entities.Producto.DetalleProducto;
import org.example.ecommercebackend.entities.Producto.Producto;
import org.example.ecommercebackend.entities.Producto.Talles;
import org.example.ecommercebackend.entities.Producto.TipoProducto;
import org.example.ecommercebackend.repositories.Producto.CategoriaRepository;
import org.example.ecommercebackend.repositories.Producto.DetalleProductoRepository;
import org.example.ecommercebackend.repositories.Producto.ProductoRepository;
import org.example.ecommercebackend.repositories.Producto.TallesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class EcommerceBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceBackendApplication.class, args);
        System.out.println("Servidor iniciando");
	}
//
//    @Bean
//    @Transactional
//    CommandLineRunner init (DetalleProductoRepository detalleProductoRepository,
//                            ProductoRepository productoRepository,
//                            CategoriaRepository categoriaRepository,
//                            TallesRepository tallesRepository){
//        return args -> {
//
//            Talles talle1 = Talles.builder().
//                    talle("45").
//                    build();
//            tallesRepository.save(talle1);
//
//            DetalleProducto detalle1 = DetalleProducto.builder().
//                    talledetalleProductos(talle1).
//                    stock(34400).
//                    color("rojo").
//                    estado(true).
//                    ImagenProducto(null).
//                    build();
//            detalleProductoRepository.save(detalle1);
//
//            DetalleProducto detalle2 = DetalleProducto.builder().
//                    talledetalleProductos(talle1).
//                    stock(50000).
//                    color("azul").
//                    estado(true).
//                    ImagenProducto(null).
//                    build();
//            detalleProductoRepository.save(detalle2);
//
//            talle1.addDetalleProducto(detalle1);
//            talle1.addDetalleProducto(detalle2);
//            tallesRepository.save(talle1);
//
//            Categoria cate1 = Categoria.builder().
//                    nombre("deportes").
//                    categoriaPadre(null).
//                    build();
//            categoriaRepository.save(cate1);
//
//            Categoria cate2 = Categoria.builder().
//                    nombre("urbano").
//                    categoriaPadre(null).
//                    build();
//            categoriaRepository.save(cate2);
//
//            Producto producto1 = Producto.builder().
//                    nombre("camiseta de futbol").
//                    categoria(cate1).
//                    tipoProducto(TipoProducto.ROPA).
//                    sexo("femenino").
//                    build();
//            productoRepository.save(producto1);
//
//            Producto producto2 = Producto.builder().
//                    nombre("zapatilla deportivas").
//                    categoria(cate1).
//                    tipoProducto(TipoProducto.ZAPATILLA).
//                    sexo("femenino").
//                    build();
//            productoRepository.save(producto2);
//
//            cate1.addProducto(producto1);
//            cate1.addProducto(producto2);
//            categoriaRepository.save(cate1);
//
//            Producto producto3 = Producto.builder().
//                    nombre("zapatilla urbanas").
//                    categoria(cate2).
//                    tipoProducto(TipoProducto.ZAPATILLA).
//                    sexo("femenino").
//                    build();
//            productoRepository.save(producto3);
//
//            Producto producto4 = Producto.builder().
//                    nombre("Remera urbana").
//                    categoria(cate2).
//                    tipoProducto(TipoProducto.ZAPATILLA).
//                    sexo("masculino").
//                    build();
//            productoRepository.save(producto4);
//
//            Producto producto5 = Producto.builder().
//                    nombre("Campera urbana").
//                    categoria(cate2).
//                    tipoProducto(TipoProducto.ROPA).
//                    sexo("masculo").
//                    build();
//            productoRepository.save(producto5);
//
//            cate2.addProducto(producto3);
//            cate2.addProducto(producto4);
//            cate2.addProducto(producto5);
//            categoriaRepository.save(cate2);
//
//        };
//    }
}
