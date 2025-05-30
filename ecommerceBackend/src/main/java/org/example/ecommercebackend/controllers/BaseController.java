package org.example.ecommercebackend.controllers;

import org.example.ecommercebackend.entities.Base;
import org.example.ecommercebackend.services.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class BaseController<E extends Base, ID extends Serializable> {
    protected BaseService<E, ID> baseService;

    public BaseController(BaseService<E, ID> baseService) {
        this.baseService = baseService;
    }

    @GetMapping
    public ResponseEntity<List<E>> listar() throws Exception {
        List<E> entities = baseService.listar();
        return ResponseEntity.ok(entities);
    }

    @GetMapping("/{id}")
    public Optional<E> buscarPorId(@PathVariable ID id) throws Exception {
        return baseService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<E> crear(@RequestBody E entity) throws Exception {
        System.out.println("Producto recibido: " + entity);
        E entidadCreada = baseService.crear(entity);
        return ResponseEntity.ok(entidadCreada);
    }

    @PutMapping
    public ResponseEntity<E> actualizar(@RequestBody E entity) throws Exception {
        E entidadActualizada = baseService.actualizar(entity);
        return ResponseEntity.ok(entidadActualizada);
    }

    @DeleteMapping("/{id}") //me parece que debemos enviar el id para eliminar
    public void eliminar(@PathVariable ID id) throws Exception {
        baseService.eliminar(id);
    }
}
