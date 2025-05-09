package org.example.ecommercebackend.repositories.Producto;

import org.example.ecommercebackend.entities.Producto.Descuento;
import org.example.ecommercebackend.repositories.BaseRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DescuentoRepository extends BaseRepository<Descuento, Long> {
}
