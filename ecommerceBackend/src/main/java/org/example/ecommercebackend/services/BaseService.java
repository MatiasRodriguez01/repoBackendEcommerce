package org.example.ecommercebackend.services;

import jakarta.transaction.Transactional;
import org.example.ecommercebackend.entities.Base;
import org.example.ecommercebackend.repositories.BaseRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseService <E extends Base, ID extends Serializable>{

    protected BaseRepository<E, ID> baseRepository;

    public BaseService(BaseRepository<E, ID> baseRepository){
        this.baseRepository = baseRepository;
    }

    @Transactional
    public List<E> listar() throws Exception {
        try {
            return baseRepository.findAll();
        } catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Transactional
    public Optional<E> buscarPorId(ID id) throws Exception{
        try {
            return Optional.ofNullable(baseRepository.findById(id).orElse(null));
        } catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Transactional
    public E crear(E entity) throws Exception {
        try {
            return baseRepository.save(entity);
        } catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Transactional
    public E actualizar(E entity) throws Exception { //no debemos usar el id?
        try {
            return baseRepository.save(entity);
        } catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Transactional
    public void eliminar(ID id) throws Exception {
        try {
            baseRepository.deleteById(id);
        } catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

}
