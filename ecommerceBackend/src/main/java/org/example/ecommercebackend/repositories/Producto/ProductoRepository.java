package org.example.ecommercebackend.repositories.Producto;

import org.example.ecommercebackend.entities.Producto.Producto;
import org.example.ecommercebackend.repositories.BaseRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductoRepository extends BaseRepository<Producto, Long> {
}
