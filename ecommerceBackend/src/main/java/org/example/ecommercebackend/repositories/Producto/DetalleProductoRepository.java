package org.example.ecommercebackend.repositories.Producto;

import org.example.ecommercebackend.entities.Producto.DetalleProducto;
import org.example.ecommercebackend.repositories.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DetalleProductoRepository extends BaseRepository<DetalleProducto, Long> {
    //filtrado detalles producto

    //filtrado por precio ascendente
    @Query(value = """
        select dt.* from productos ps
        inner join detalle_producto dt on dt.producto_id = ps.id
        inner join categorias c on c.id = ps.fk_categoria
        inner join fk_talle ft on ft.id_detalle = dt.id
        inner join talles t on t.id = ft.id_talle
        inner join precios p on p.id = dt.fk_precio
        where (:seccion IS NULL OR :seccion = "" OR ps.seccion = :seccion) and
        (:categoria IS NULL OR :categoria = "" OR c.nombre = :categoria)
        and (:talle IS NULL OR :talle = "" OR t.talle = :talle)
        and (:tipo IS NULL OR :tipo = "" OR ps.tipo_producto = :tipo)
        and (:buscador IS NULL OR :buscador = "" OR ps.nombre like concat('%', :buscador, '%'))
        and (:precioMaximo IS NULL OR :precioMaximo = 0 OR  p.precio_venta <= :precioMaximo)
        order by p.precio_venta asc;
    """, nativeQuery = true)
    List<DetalleProducto> ordenarDetallesProductoPrecioAscendiente(@Param("seccion") String seccion,
                                                                   @Param("categoria") String categoria,
                                                                   @Param("talle") String talle,
                                                                   @Param("tipo") String tipo,
                                                                   @Param("buscador") String buscador,
                                                                   @Param("precioMaximo") Integer precioMaximo);

    //filtrado por precio descendente
    @Query(value = """

            select dt.* from productos ps
        inner join detalle_producto dt on dt.producto_id = ps.id
        inner join categorias c on c.id = ps.fk_categoria
        inner join fk_talle ft on ft.id_detalle = dt.id
        inner join talles t on t.id = ft.id_talle
        inner join precios p on p.id = dt.fk_precio
        where (:seccion IS NULL OR :seccion = "" OR ps.seccion = :seccion) and
        (:categoria IS NULL OR :categoria = "" OR c.nombre = :categoria)
        and (:talle IS NULL OR :talle = "" OR  t.talle = :talle)
        and (:tipo IS NULL OR :tipo = "" OR ps.tipo_producto = :tipo)
        and (:buscador IS NULL OR :buscador = "" OR ps.nombre like concat('%', :buscador, '%'))
        and (:precioMaximo IS NULL OR :precioMaximo = 0 OR p.precio_venta <= :precioMaximo)
        order by p.precio_venta desc;
    """, nativeQuery = true)
    List<DetalleProducto> ordenarDetallesProductoPrecioDescendente(@Param("seccion") String seccion,
                                                                  @Param("categoria") String categoria,
                                                                  @Param("talle") String talle,
                                                                  @Param("tipo") String tipo,
                                                                  @Param("buscador") String buscador,
                                                                  @Param("precioMaximo") Integer precioMaximo);

    //filtrado sin orden de los precios
    @Query(value =  """
    select dt.* from productos ps
        inner join detalle_producto dt on dt.producto_id = ps.id
        inner join categorias c on c.id = ps.fk_categoria
        inner join fk_talle ft on ft.id_detalle = dt.id
        inner join talles t on t.id = ft.id_talle
        inner join precios p on p.id = dt.fk_precio
        where (:seccion IS NULL OR :seccion = "" OR  ps.seccion = :seccion) and
        (:categoria IS NULL OR :categoria = "" OR c.nombre = :categoria)
        and (:talle IS NULL OR :talle = "" OR  t.talle = :talle)
        and (:tipo IS NULL OR :tipo = "" OR ps.tipo_producto = :tipo)
        and (:buscador IS NULL OR :buscador = "" OR ps.nombre like concat('%', :buscador, '%'))
        and (:precioMaximo IS NULL OR :precioMaximo = 0 OR p.precio_venta <= :precioMaximo);
    """, nativeQuery = true)
    List<DetalleProducto> ordenarDetallesProductosSinOrdenPrecioo(@Param("seccion") String seccion,
                                                                  @Param("categoria") String categoria,
                                                                  @Param("talle") String talle,
                                                                  @Param("tipo") String tipo,
                                                                  @Param("buscador") String buscador,
                                                                  @Param("precioMaximo") Integer precioMaximo);


 }