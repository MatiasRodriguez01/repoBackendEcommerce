package org.example.ecommercebackend.services.Producto;

import jakarta.transaction.Transactional;
import org.example.ecommercebackend.entities.Producto.Categoria;
import org.example.ecommercebackend.entities.Producto.Producto;
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

    /// METODOS PARA CATEGORIA_PADRE
    // metodo para agregar una categoriaPadre
    @Transactional
    public Categoria agregarCategoriaPadre(Long idCategoria, Categoria newCatePadre) throws Exception {
        try {
            Categoria categoria = categoriaRepository.findById(idCategoria)
                    .orElseThrow(() -> new Exception("categoria no encontrado con id: " + idCategoria));

            if (categoria.getCategoriaPadre() != null) {
                throw new Exception("Categoria " + categoria.getNombre() + " ya tiene categoria Padre!!");
            }
            categoria.setCategoriaPadre(newCatePadre);
            return categoriaRepository.save(categoria);
        } catch (Exception ex) {
            throw new Exception("Ocurrio un error en el servicio (agregarCategoriaPadre): " + ex.getMessage());
        }
    }

    // metodo para sacar categoriaPadre
    @Transactional
    public Categoria sacarCategoriaPadre(Long idCategoria) throws Exception {
        try {
            Categoria categoria = categoriaRepository.findById(idCategoria)
                    .orElseThrow(() -> new Exception("categoria no encontrado con id: " + idCategoria));

            categoria.setCategoriaPadre(null);
            return categoriaRepository.save(categoria);
        } catch (Exception ex) {
            throw new Exception("Ocurrio un error en el servicio (sacarCategoriaPadre): " + ex.getMessage());
        }
    }

    ///  METODOS PARA PRODUCTOS
    //   metodo para agregar un producto
    @Transactional
    public Categoria agregarProducto(Long idCategoria, Producto newProducto) throws Exception {
        try {
            Categoria categoria = categoriaRepository.findById(idCategoria)
                    .orElseThrow(() -> new Exception("categoria no encontrado con id: " + idCategoria));

            categoria.getProductos().add(newProducto);
            return categoriaRepository.save(categoria);
        } catch (Exception ex) {
            throw new Exception("Ocurrio un error en el servicio (agregarProducto): " + ex.getMessage());
        }
    }

    // metodo para eliminar un producto
    @Transactional
    public Categoria sacarProducto(Long idCategoria, Producto productoEliminar) throws Exception {
        try {
            Categoria categoria = categoriaRepository.findById(idCategoria)
                    .orElseThrow(() -> new Exception("categoria no encontrado con id: " + idCategoria));

            categoria.getProductos().removeIf(producto -> producto.getId() == productoEliminar.getId());
            return categoriaRepository.save(categoria);
        } catch (Exception ex) {
            throw new Exception("Ocurrio un error en el servicio (sacarProducto): " + ex.getMessage());
        }
    }
}