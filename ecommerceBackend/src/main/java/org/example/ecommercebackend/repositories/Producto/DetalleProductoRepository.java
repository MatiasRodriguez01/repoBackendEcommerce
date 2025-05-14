package org.example.ecommercebackend.repositories.Producto;

import org.example.ecommercebackend.entities.Producto.DetalleProducto;
import org.example.ecommercebackend.repositories.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

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

}
