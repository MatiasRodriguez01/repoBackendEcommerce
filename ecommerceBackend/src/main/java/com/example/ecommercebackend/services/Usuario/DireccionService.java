package org.example.ecommercebackend.services.Usuario;

import org.example.ecommercebackend.entities.Usuario.Direccion;
import org.example.ecommercebackend.repositories.BaseRepository;
import org.example.ecommercebackend.repositories.Usuario.DireccionRepository;
import org.example.ecommercebackend.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DireccionService extends BaseService<Direccion, Long> {

    @Autowired
    private DireccionRepository direccionRepository;

    public DireccionService(DireccionRepository direccionRepository) {
        super(direccionRepository);
    }
}
