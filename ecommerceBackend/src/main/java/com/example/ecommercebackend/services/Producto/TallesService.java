package org.example.ecommercebackend.services.Producto;

import org.example.ecommercebackend.entities.Producto.Talles;
import org.example.ecommercebackend.repositories.BaseRepository;
import org.example.ecommercebackend.repositories.Producto.TallesRepository;
import org.example.ecommercebackend.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TallesService extends BaseService<Talles, Long> {

    @Autowired
    private TallesRepository tallesRepository;

    public TallesService(TallesRepository tallesRepository) {
        super(tallesRepository);
    }
}
