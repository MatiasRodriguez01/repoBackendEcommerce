package org.example.ecommercebackend.repositories.Producto;

import org.example.ecommercebackend.entities.Producto.DetalleProducto;
import org.example.ecommercebackend.repositories.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleProductoRepository extends BaseRepository<DetalleProducto, Long> {

    @Query(value = """
            SELECT DISTINCT dp.*
            FROM productos p
            INNER JOIN categorias c ON p.fk_categoria = c.id
            INNER JOIN detalle_producto dp ON p.id = dp.producto_id
            INNER Join fk_talle ft ON ft.id_detalle = dp.id
            INNER JOIN talles t ON t.id = ft.id_talle
            WHERE t.talle = :talle AND c.nombre = :categoria;
            """, nativeQuery = true)
    List<DetalleProducto> buscarPorTalleYCategoria(@Param("talle") String talle, @Param("categoria") String categoria);

    @Query(value = """
            SELECT DISTINCT dp.*
            FROM productos p
            INNER JOIN detalle_producto dp ON p.id = dp.producto_id
            WHERE p.tipo_producto = :producto;
            """, nativeQuery = true)
    List<DetalleProducto> ordernarPorTipoProducto(@Param("producto") String tipo);

    @Query(value = """
            SELECT dp.*
            FROM productos p
            INNER JOIN detalle_producto dp ON p.id = dp.producto_id
            INNER JOIN precios ps ON ps.id = dp.fk_precio
            ORDER BY ps.precio_venta ASC;
            """, nativeQuery = true)
    List<DetalleProducto> ordenarPrecioAscendiente();

    @Query(value = """
            SELECT dp.*
            FROM productos p
            INNER JOIN detalle_producto dp ON p.id = dp.producto_id
            INNER JOIN precios ps ON ps.id = dp.fk_precio
            ORDER BY ps.precio_venta desc;
            """, nativeQuery = true)
    List<DetalleProducto> ordenarPrecioDescendiente();



}
