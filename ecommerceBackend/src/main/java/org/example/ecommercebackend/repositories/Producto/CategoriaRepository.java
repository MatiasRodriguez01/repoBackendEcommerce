package org.example.ecommercebackend.repositories.Producto;

import org.example.ecommercebackend.entities.Producto.Categoria;
import org.example.ecommercebackend.repositories.BaseRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepository extends BaseRepository<Categoria,Long> {

}
