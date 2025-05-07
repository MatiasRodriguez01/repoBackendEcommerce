package org.example.ecommercebackend.services.Producto;

import org.example.ecommercebackend.entities.Producto.Categoria;
import org.example.ecommercebackend.repositories.Producto.CategoriaRepository;
import org.example.ecommercebackend.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService extends BaseService<Categoria, Long> {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        super(categoriaRepository);
    }
}
