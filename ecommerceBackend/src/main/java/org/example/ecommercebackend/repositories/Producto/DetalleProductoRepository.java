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
        select dt.* from productos ps
        	inner join detalle_producto dt on dt.producto_id = ps.id
            inner join categorias c on c.id = ps.fk_categoria
        where ps.seccion = :seccion and c.nombre = :categoria;
    """, nativeQuery = true)
    List<DetalleProducto> ordenarDetallesPorProducto(@Param("seccion") String seccion,
                                                     @Param("categoria") String categoria);

    @Query(value = """
        select dt.* from productos ps
        	inner join detalle_producto dt on dt.producto_id = ps.id
            	inner join categorias c on c.id = ps.fk_categoria
            	inner join fk_talle ft on ft.id_detalle = dt.id
        	inner join talles t on t.id = ft.id_talle
        where ps.seccion = :seccion and c.nombre = :categoria and t.talle = :talle;    
    """, nativeQuery = true)
    List<DetalleProducto> ordenarDetallesPorTalleDeProducto(@Param("seccion") String seccion,
                                                            @Param("categoria") String categoria,
                                                            @Param("talle") String talle);

    @Query(value = """
        select dt.* from productos ps
        	inner join detalle_producto dt on dt.producto_id = ps.id
            inner join categorias c on c.id = ps.fk_categoria
        where ps.seccion = :seccion and c.nombre = :categoria and ps.tipo_producto = :tipo;
    """, nativeQuery = true)
    List<DetalleProducto> ordenarDetallePorTipodeproducto(@Param("seccion") String seccion,
                                                          @Param("categoria") String categoria,
                                                          @Param("tipo") String tipo);

    @Query(value = """
        select dt.* from productos ps
        	inner join detalle_producto dt on dt.producto_id = ps.id
            	inner join categorias c on c.id = ps.fk_categoria
        	inner join precios p on p.id = dt.fk_precio
        where ps.seccion = :seccion and c.nombre = :categoria
        order by p.precio_venta asc;
    """, nativeQuery = true)
    List<DetalleProducto> ordenarDetallePorPrecioAscendente(@Param("seccion") String seccion,
                                                            @Param("categoria") String categoria);

    @Query(value = """
        select dt.* from productos ps
        	inner join detalle_producto dt on dt.producto_id = ps.id
            	inner join categorias c on c.id = ps.fk_categoria
        	inner join precios p on p.id = dt.fk_precio
        where ps.seccion = :seccion and c.nombre = :categoria
        order by p.precio_venta desc;
    """, nativeQuery = true)
    List<DetalleProducto> ordenarDetallePorPrecioDescendente(@Param("seccion") String seccion,
                                                             @Param("categoria") String categoria);

    @Query(value = """
    select dt.* from productos ps
    	inner join detalle_producto dt on dt.producto_id = ps.id
        inner join categorias c on c.id = ps.fk_categoria
    	inner join precios p on p.id = dt.fk_precio
    where ps.seccion = :seccion and c.nombre = :categoria and ps.tipo_producto = :tipo
    order by p.precio_venta asc;
""", nativeQuery = true)
    List<DetalleProducto> ordenarDetalleSinTalleAscendiente(@Param("seccion") String seccion,
                                                            @Param("categoria") String categoria,
                                                            @Param("tipo") String tipo);

    @Query(value = """
    select dt.* from productos ps
    	inner join detalle_producto dt on dt.producto_id = ps.id
        inner join categorias c on c.id = ps.fk_categoria
    	inner join precios p on p.id = dt.fk_precio
    where ps.seccion = :seccion and c.nombre = :categoria and ps.tipo_producto = :tipo
    order by p.precio_venta desc;
""", nativeQuery = true)
    List<DetalleProducto> ordenarDetalleSinTalleDescendiente(@Param("seccion") String seccion,
                                                             @Param("categoria") String categoria,
                                                             @Param("tipo") String tipo);

    @Query(value = """
            select dt.* from productos ps
            	inner join detalle_producto dt on dt.producto_id = ps.id
                inner join categorias c on c.id = ps.fk_categoria
            	inner join precios p on p.id = dt.fk_precio
            	inner join fk_talle ft on ft.id_detalle = dt.id
        	inner join talles t on t.id = ft.id_talle
            where ps.seccion = :seccion and c.nombre = :categoria  and t.talle = :talle
            order by p.precio_venta asc;
            """, nativeQuery = true)
    List<DetalleProducto> ordenarDetalleSinTipoAscendiente(@Param("seccion") String seccion,
                                                           @Param("categoria") String categoria,
                                                           @Param("talle") String talle);

    @Query(value = """
            select dt.* from productos ps
            	inner join detalle_producto dt on dt.producto_id = ps.id
                inner join categorias c on c.id = ps.fk_categoria
            	inner join precios p on p.id = dt.fk_precio
            	inner join fk_talle ft on ft.id_detalle = dt.id
        	inner join talles t on t.id = ft.id_talle
            where ps.seccion = :seccion and c.nombre = :categoria  and t.talle = :talle
            order by p.precio_venta desc;
            """, nativeQuery = true)
    List<DetalleProducto> ordenarDetalleSinTipoDescendiente(@Param("seccion") String seccion,
                                                            @Param("categoria") String categoria,
                                                            @Param("talle") String talle);

    @Query(value = """
            select dt.* from productos ps
            	inner join detalle_producto dt on dt.producto_id = ps.id
                inner join categorias c on c.id = ps.fk_categoria
            	inner join precios p on p.id = dt.fk_precio
            	inner join fk_talle ft on ft.id_detalle = dt.id
        	inner join talles t on t.id = ft.id_talle
            where ps.seccion = :seccion and c.nombre = :categoria  and t.talle = :talle and ps.tipo_producto = :tipo;
            """, nativeQuery = true)
    List<DetalleProducto> ordenarDetalleSinOrden(@Param("seccion") String seccion,
                                                 @Param("categoria") String categoria,
                                                 @Param("talle") String talle,
                                                 @Param("tipo") String tipo);

    @Query(value = """
        select dt.* from productos ps
            inner join detalle_producto dt on dt.producto_id = ps.id
            inner join categorias c on c.id = ps.fk_categoria
            inner join precios p on p.id = dt.fk_precio
            inner join fk_talle ft on ft.id_detalle = dt.id
        	inner join talles t on t.id = ft.id_talle
        where ps.seccion = :seccion and c.nombre = :categoria  and t.talle = :talle and ps.tipo_producto = :tipo
        order by p.precio_venta asc;
            """, nativeQuery = true)
    List<DetalleProducto> filtrarDetalleProductoAscendiente(@Param("seccion") String seccion,
                                                            @Param("categoria") String categoria,
                                                            @Param("talle") String talle,
                                                            @Param("tipo") String tipo);

    @Query(value = """
    select dt.* from productos ps
        inner join detalle_producto dt on dt.producto_id = ps.id
        inner join categorias c on c.id = ps.fk_categoria
        inner join precios p on p.id = dt.fk_precio
        inner join fk_talle ft on ft.id_detalle = dt.id
        inner join talles t on t.id = ft.id_talle
    where ps.seccion = :seccion and c.nombre = :categoria  and t.talle = :talle and ps.tipo_producto = :tipo
    order by p.precio_venta desc;
            """, nativeQuery = true)
    List<DetalleProducto> filtrarDetalleProductoDescendiente(@Param("seccion") String seccion,
                                                             @Param("categoria") String categoria,
                                                             @Param("talle") String talle,
                                                             @Param("tipo") String tipo);
}
