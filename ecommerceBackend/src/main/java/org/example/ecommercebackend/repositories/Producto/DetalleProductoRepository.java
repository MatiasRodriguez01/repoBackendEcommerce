package org.example.ecommercebackend.repositories.Producto;

import org.example.ecommercebackend.entities.Producto.DetalleProducto;
import org.example.ecommercebackend.repositories.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DetalleProductoRepository extends BaseRepository<DetalleProducto, Long> {
    //parte CATALOGO COMPLETO
    @Query(value = """
        select dt.* from productos ps
        inner join detalle_producto dt on dt.producto_id = ps.id
        inner join fk_talle ft on ft.id_detalle = dt.id
        inner join talles t on t.id = ft.id_talle
        where t.talle = :talle;
    """, nativeQuery = true)
    List<DetalleProducto> ordenarDetallesPorTalleDeProductoCatalogoCompleto(@Param("talle") String talle);

    @Query(value = """
        select dt.* from productos ps
        inner join detalle_producto dt on dt.producto_id = ps.id
        inner join fk_talle ft on ft.id_detalle = dt.id
        inner join talles t on t.id = ft.id_talle
        where t.talle = :talle and ps.nombre like concat('%', :buscador, '%');
    """, nativeQuery = true)
    List<DetalleProducto> ordenarDetallesPorTalleDeProductoCatalogoCompletoBuscador(@Param("talle") String talle,
                                                                                    @Param("buscador") String buscador);

    @Query(value = """
        select dt.* from productos ps
        inner join detalle_producto dt on dt.producto_id = ps.id
        where ps.tipo_producto = :tipo
    """, nativeQuery = true)
    List<DetalleProducto> ordenarDetallesPorTipoDeProductoCatalogoCompleto(@Param("tipo") String tipo);

    @Query(value = """
        select dt.* from productos ps
        inner join detalle_producto dt on dt.producto_id = ps.id
        where ps.tipo_producto = :tipo and ps.nombre like concat('%', :buscador, '%');
    """, nativeQuery = true)
    List<DetalleProducto> ordenarDetallesPorTipoDeProductoCatalogoCompletoBuscador(@Param("tipo") String tipo,
                                                                                   @Param("buscador") String buscador);

    @Query(value = """
        select dt.* from productos ps
        	inner join detalle_producto dt on dt.producto_id = ps.id
        	inner join precios p on p.id = dt.fk_precio
        order by p.precio_venta asc;
    """, nativeQuery = true)
    List<DetalleProducto> ordenarDetallePorPrecioAscendenteCatalogoCompleto();

    @Query(value = """
        select dt.* from productos ps
        	inner join detalle_producto dt on dt.producto_id = ps.id
        	inner join precios p on p.id = dt.fk_precio
        order by p.precio_venta desc;
    """, nativeQuery = true)
    List<DetalleProducto> ordenarDetallePorPrecioDescendenteCatalogoCompleto();

    @Query(value = """
        select dt.* from productos ps
        	inner join detalle_producto dt on dt.producto_id = ps.id
        	inner join precios p on p.id = dt.fk_precio
            where ps.nombre like concat('%', :buscador, '%')
        order by p.precio_venta asc;
    """, nativeQuery = true)
    List<DetalleProducto> ordenarDetallePorPrecioAscendenteCatalogoCompletoBuscador(@Param("buscador") String buscador);

    @Query(value = """
        select dt.* from productos ps
        	inner join detalle_producto dt on dt.producto_id = ps.id
        	inner join precios p on p.id = dt.fk_precio
            where ps.nombre like concat('%', :buscador, '%')
        order by p.precio_venta desc;
    """, nativeQuery = true)
    List<DetalleProducto> ordenarDetallePorPrecioDescendenteCatalogoCompletoBuscador(@Param("buscador") String buscador);

    @Query(value = """
    select dt.* from productos ps
    	inner join detalle_producto dt on dt.producto_id = ps.id
    	inner join precios p on p.id = dt.fk_precio
    where ps.tipo_producto = :tipo
    order by p.precio_venta asc;
""", nativeQuery = true)
    List<DetalleProducto> ordenarDetalleSinTalleAscendienteCatalogoCompleto(@Param("tipo") String tipo);

    @Query(value = """
    select dt.* from productos ps
    	inner join detalle_producto dt on dt.producto_id = ps.id
    	inner join precios p on p.id = dt.fk_precio
    where ps.tipo_producto = :tipo
    order by p.precio_venta desc;
""", nativeQuery = true)
    List<DetalleProducto> ordenarDetalleSinTalleDescendienteCatalogoCompleto(@Param("tipo") String tipo);

    @Query(value = """
    select dt.* from productos ps
    	inner join detalle_producto dt on dt.producto_id = ps.id
    	inner join precios p on p.id = dt.fk_precio
    where ps.tipo_producto = :tipo and ps.nombre like concat('%', :buscador, '%')
    order by p.precio_venta asc;
""", nativeQuery = true)
    List<DetalleProducto> ordenarDetalleSinTalleAscendienteCatalogoCompletoBuscador(@Param("tipo") String tipo,
                                                                                    @Param("buscador") String buscador);

    @Query(value = """
    select dt.* from productos ps
    	inner join detalle_producto dt on dt.producto_id = ps.id
    	inner join precios p on p.id = dt.fk_precio
    where ps.tipo_producto = :tipo and ps.nombre like concat('%', :buscador, '%')
    order by p.precio_venta desc;
""", nativeQuery = true)
    List<DetalleProducto> ordenarDetalleSinTalleDescendienteCatalogoCompletoBuscador(@Param("tipo") String tipo,
                                                                                     @Param("buscador") String buscador);

    @Query(value = """
            select dt.* from productos ps
            	inner join detalle_producto dt on dt.producto_id = ps.id
            	inner join precios p on p.id = dt.fk_precio
            	inner join fk_talle ft on ft.id_detalle = dt.id
        	inner join talles t on t.id = ft.id_talle
            where t.talle = :talle
            order by p.precio_venta asc;
            """, nativeQuery = true)
    List<DetalleProducto> ordenarDetalleSinTipoAscendienteCatalogoCompleto(@Param("talle") String talle);

    @Query(value = """
            select dt.* from productos ps
            	inner join detalle_producto dt on dt.producto_id = ps.id
            	inner join precios p on p.id = dt.fk_precio
            	inner join fk_talle ft on ft.id_detalle = dt.id
        	inner join talles t on t.id = ft.id_talle
            where t.talle = :talle
            order by p.precio_venta desc;
            """, nativeQuery = true)
    List<DetalleProducto> ordenarDetalleSinTipoDescendienteCatalogoCompleto(@Param("talle") String talle);

    @Query(value = """
            select dt.* from productos ps
            	inner join detalle_producto dt on dt.producto_id = ps.id
            	inner join precios p on p.id = dt.fk_precio
            	inner join fk_talle ft on ft.id_detalle = dt.id
        	inner join talles t on t.id = ft.id_talle
            where t.talle = :talle and ps.nombre like concat('%', :buscador, '%')
            order by p.precio_venta asc;
            """, nativeQuery = true)
    List<DetalleProducto> ordenarDetalleSinTipoAscendienteCatalogoCompletoBuscador(@Param("talle") String talle,
                                                                                    @Param("buscador") String buscador);

    @Query(value = """
            select dt.* from productos ps
            	inner join detalle_producto dt on dt.producto_id = ps.id
            	inner join precios p on p.id = dt.fk_precio
            	inner join fk_talle ft on ft.id_detalle = dt.id
        	inner join talles t on t.id = ft.id_talle
            where t.talle = :talle and ps.nombre like concat('%', :buscador, '%')
            order by p.precio_venta desc;
            """, nativeQuery = true)
    List<DetalleProducto> ordenarDetalleSinTipoDescendienteCatalogoCompletoBuscador(@Param("talle") String talle,
                                                                                    @Param("buscador") String buscador);

    @Query(value = """
            select dt.* from productos ps
            	inner join detalle_producto dt on dt.producto_id = ps.id
            	inner join precios p on p.id = dt.fk_precio
            	inner join fk_talle ft on ft.id_detalle = dt.id
        	inner join talles t on t.id = ft.id_talle
            where t.talle = :talle and ps.tipo_producto = :tipo;
            """, nativeQuery = true)
    List<DetalleProducto> ordenarDetalleSinOrdenCatalogoCompleto(@Param("talle") String talle,
                                                 @Param("tipo") String tipo);

    @Query(value = """
            select dt.* from productos ps
            	inner join detalle_producto dt on dt.producto_id = ps.id
            	inner join precios p on p.id = dt.fk_precio
            	inner join fk_talle ft on ft.id_detalle = dt.id
        	inner join talles t on t.id = ft.id_talle
            where t.talle = :talle and ps.tipo_producto = :tipo and ps.nombre like concat('%', :buscador, '%');
            """, nativeQuery = true)
    List<DetalleProducto> ordenarDetalleSinOrdenCatalogoCompletoBuscador(@Param("talle") String talle,
                                                                         @Param("tipo") String tipo,
                                                                         @Param("buscador") String buscador);

    @Query(value = """
        select dt.* from productos ps
        inner join detalle_producto dt on dt.producto_id = ps.id
        where ps.nombre like concat('%', :buscador, '%');
    """, nativeQuery = true)
    List<DetalleProducto> filtrarDetallesPorBusquedaCatalogoCompleto(@Param("buscador") String buscador);

    //parte filtrado por CATEGORIA Y SECCION
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
<<<<<<< HEAD
            inner join categorias c on c.id = ps.fk_categoria
        where ps.seccion = :seccion and c.nombre = :categoria and ps.nombre like concat('%', :buscador, '%');
    """, nativeQuery = true)
    List<DetalleProducto> ordenarDetallesPorProductoBuscador(@Param("seccion") String seccion,
                                                            @Param("categoria") String categoria,
                                                            @Param("buscador") String buscador);

    @Query(value = """
        select dt.* from productos ps
        	inner join detalle_producto dt on dt.producto_id = ps.id
=======
>>>>>>> origin/master
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
            	inner join fk_talle ft on ft.id_detalle = dt.id
        	inner join talles t on t.id = ft.id_talle
        where ps.seccion = :seccion and c.nombre = :categoria and t.talle = :talle and ps.nombre like concat('%', :buscador, '%');    
    """, nativeQuery = true)
    List<DetalleProducto> ordenarDetallesPorTalleDeProductoBuscador(@Param("seccion") String seccion,
                                                            @Param("categoria") String categoria,
                                                            @Param("talle") String talle,
                                                            @Param("buscador") String buscador);

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
<<<<<<< HEAD
            inner join categorias c on c.id = ps.fk_categoria
        where ps.seccion = :seccion and c.nombre = :categoria and ps.tipo_producto = :tipo and ps.nombre like concat('%', :buscador, '%');
    """, nativeQuery = true)
    List<DetalleProducto> ordenarDetallePorTipodeproductoBuscador(@Param("seccion") String seccion,
                                                          @Param("categoria") String categoria,
                                                          @Param("tipo") String tipo,
                                                          @Param("buscador") String buscador);

    @Query(value = """
        select dt.* from productos ps
        	inner join detalle_producto dt on dt.producto_id = ps.id
=======
>>>>>>> origin/master
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
        where ps.seccion = :seccion and c.nombre = :categoria and ps.nombre like concat('%', :buscador, '%')
        order by p.precio_venta asc;
    """, nativeQuery = true)
    List<DetalleProducto> ordenarDetallePorPrecioAscendenteBuscador(@Param("seccion") String seccion,
                                                                    @Param("categoria") String categoria,
                                                                    @Param("buscador") String buscador);

    @Query(value = """
        select dt.* from productos ps
        	inner join detalle_producto dt on dt.producto_id = ps.id
            	inner join categorias c on c.id = ps.fk_categoria
        	inner join precios p on p.id = dt.fk_precio
        where ps.seccion = :seccion and c.nombre = :categoria and ps.nombre like concat('%', :buscador, '%')
        order by p.precio_venta desc;
    """, nativeQuery = true)
    List<DetalleProducto> ordenarDetallePorPrecioDescendenteBuscador(@Param("seccion") String seccion,
                                                                     @Param("categoria") String categoria,
                                                                     @Param("buscador") String buscador);

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
    where ps.seccion = :seccion and c.nombre = :categoria and ps.tipo_producto = :tipo and ps.nombre like concat('%', :buscador, '%')
    order by p.precio_venta asc;
""", nativeQuery = true)
    List<DetalleProducto> ordenarDetalleSinTalleAscendienteBuscador(@Param("seccion") String seccion,
                                                                    @Param("categoria") String categoria,
                                                                    @Param("tipo") String tipo,
                                                                    @Param("buscador") String buscador);

    @Query(value = """
    select dt.* from productos ps
    	inner join detalle_producto dt on dt.producto_id = ps.id
        inner join categorias c on c.id = ps.fk_categoria
    	inner join precios p on p.id = dt.fk_precio
    where ps.seccion = :seccion and c.nombre = :categoria and ps.tipo_producto = :tipo and ps.nombre like concat('%', :buscador, '%')
    order by p.precio_venta desc;
""", nativeQuery = true)
    List<DetalleProducto> ordenarDetalleSinTalleDescendienteBuscador(@Param("seccion") String seccion,
                                                                     @Param("categoria") String categoria,
                                                                     @Param("tipo") String tipo,
                                                                     @Param("buscador") String buscador);

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
<<<<<<< HEAD
            where ps.seccion = :seccion and c.nombre = :categoria  and t.talle = :talle
            order by p.precio_venta asc;
            """, nativeQuery = true)
    List<DetalleProducto> ordenarDetalleSinTipoAscendienteBuscador(@Param("seccion") String seccion,
                                                                   @Param("categoria") String categoria,
                                                                   @Param("talle") String talle,
                                                                   @Param("buscador") String buscador);

    @Query(value = """
            select dt.* from productos ps
            	inner join detalle_producto dt on dt.producto_id = ps.id
                inner join categorias c on c.id = ps.fk_categoria
            	inner join precios p on p.id = dt.fk_precio
            	inner join fk_talle ft on ft.id_detalle = dt.id
        	inner join talles t on t.id = ft.id_talle
            where ps.seccion = :seccion and c.nombre = :categoria  and t.talle = :talle and ps.nombre like concat('%', :buscador, '%')
            order by p.precio_venta desc;
            """, nativeQuery = true)
    List<DetalleProducto> ordenarDetalleSinTipoDescendienteBuscador(@Param("seccion") String seccion,
                                                                    @Param("categoria") String categoria,
                                                                    @Param("talle") String talle,
                                                                    @Param("buscador") String buscador);

    @Query(value = """
            select dt.* from productos ps
            	inner join detalle_producto dt on dt.producto_id = ps.id
                inner join categorias c on c.id = ps.fk_categoria
            	inner join precios p on p.id = dt.fk_precio
            	inner join fk_talle ft on ft.id_detalle = dt.id
        	inner join talles t on t.id = ft.id_talle
            where ps.seccion = :seccion and c.nombre = :categoria  and t.talle = :talle and ps.tipo_producto = :tipo and ps.nombre like concat('%', :buscador, '%');
            """, nativeQuery = true)
    List<DetalleProducto> ordenarDetalleSinOrdenBuscador(@Param("seccion") String seccion,
                                                         @Param("categoria") String categoria,
                                                         @Param("talle") String talle,
                                                         @Param("tipo") String tipo,
                                                         @Param("buscador") String buscador);

    @Query(value = """
            select dt.* from productos ps
            	inner join detalle_producto dt on dt.producto_id = ps.id
                inner join categorias c on c.id = ps.fk_categoria
            	inner join precios p on p.id = dt.fk_precio
            	inner join fk_talle ft on ft.id_detalle = dt.id
        	inner join talles t on t.id = ft.id_talle
=======
>>>>>>> origin/master
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
<<<<<<< HEAD
        where ps.seccion = :seccion and c.nombre = :categoria  and t.talle = :talle and ps.tipo_producto = :tipo and ps.nombre like concat('%', :buscador, '%')
=======
        where ps.seccion = :seccion and c.nombre = :categoria  and t.talle = :talle and ps.tipo_producto = :tipo
>>>>>>> origin/master
        order by p.precio_venta asc;
            """, nativeQuery = true)
    List<DetalleProducto> filtrarDetalleProductoAscendiente(@Param("seccion") String seccion,
                                                            @Param("categoria") String categoria,
                                                            @Param("talle") String talle,
                                                            @Param("tipo") String tipo,
                                                            @Param("buscador") String buscador);

    @Query(value = """
    select dt.* from productos ps
        inner join detalle_producto dt on dt.producto_id = ps.id
        inner join categorias c on c.id = ps.fk_categoria
        inner join precios p on p.id = dt.fk_precio
        inner join fk_talle ft on ft.id_detalle = dt.id
        inner join talles t on t.id = ft.id_talle
<<<<<<< HEAD
    where ps.seccion = :seccion and c.nombre = :categoria  and t.talle = :talle and ps.tipo_producto = :tipo and ps.nombre like concat('%', :buscador, '%')
=======
    where ps.seccion = :seccion and c.nombre = :categoria  and t.talle = :talle and ps.tipo_producto = :tipo
>>>>>>> origin/master
    order by p.precio_venta desc;
            """, nativeQuery = true)
    List<DetalleProducto> filtrarDetalleProductoDescendiente(@Param("seccion") String seccion,
                                                             @Param("categoria") String categoria,
                                                             @Param("talle") String talle,
                                                             @Param("tipo") String tipo,
                                                             @Param("buscador") String buscador);



}
