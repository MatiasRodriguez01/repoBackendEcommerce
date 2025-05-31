package org.example.ecommercebackend.services.Producto;


import org.example.ecommercebackend.entities.Producto.Categoria;
import org.example.ecommercebackend.entities.Producto.DetalleProducto;
import org.example.ecommercebackend.entities.Producto.Producto;
import org.example.ecommercebackend.repositories.Producto.ProductoRepository;
import org.example.ecommercebackend.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoService extends BaseService<Producto, Long> {

    @Autowired
    private ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        super(productoRepository);
    }

    public Producto crear(Producto producto) {
        // Aquí podés agregar lógica adicional si necesitás
        return productoRepository.save(producto);
    }

    // ----------------------- METODOS PARA LAS CONSULTAS DE LA BD -------------------------
    @Transactional(rollbackFor = Exception.class)
    public List<DetalleProducto> filtarDetalleProducto(Long id, String seccion,
                                                       String categoria, String talle,
                                                       String tipo, String orden) throws Exception {
        try {

//            if ((seccion != "FEMENINO") || (seccion != "MASCULINO")) {
//                throw new Exception("En seccion debera ingresar uno de los siguientes campos: [FEMENINO, MASCULINO]");
//            }
//            if (!(tipo == "ROPA") || !(tipo == "ZAPATILLA")) {
//                throw new Exception("En seccion debera ingresar uno de los siguientes campos: [ROPA, ZAPATILLA]");
//            }
//            if(!orden.equals("asc") || !orden.equals("desc")){
//                throw new Exception("El atributo 'orden' deber ser: [desc o asc]");
//            }
            switch(orden) {
                case "asc":
                    return productoRepository.filtrarDetalleProductoAscendiente(id, seccion, categoria, talle, tipo);
                case "desc":
                    return productoRepository.filtrarDetalleProductoDescendiente(id, seccion, categoria, talle, tipo);
            }

            throw new Exception("En seccion debera seleccionar: [des o asc]");
        }   catch (Exception e) {
            throw new RuntimeException("Ocurrio un error al mostrar los detalles de producto[" + id +"]: " + e.getMessage());
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public List<DetalleProducto> ordenarDetalleSinOrden(Long id, String seccion,
                                                        String categoria, String talle,
                                                        String tipo) throws Exception {
        try {

//            if ((seccion != "FEMENINO") || (seccion != "MASCULINO")) {
//                throw new Exception("En seccion debera ingresar uno de los siguientes campos: [FEMENINO, MASCULINO]");
//            }
//            if (!(tipo == "ROPA") || !(tipo == "ZAPATILLA")) {
//                throw new Exception("En seccion debera ingresar uno de los siguientes campos: [ROPA, ZAPATILLA]");
//            }
            return productoRepository.ordenarDetalleSinOrden(id, seccion, categoria, talle, tipo);
        } catch (Exception e) {
            throw new RuntimeException("Ocurrio un error al ordenar sin orden los detalles de producto[" + id +"]: " + e.getMessage());
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public List<DetalleProducto> ordenarDetalleSinTipo(Long id, String seccion,
                                                       String categoria, String talle,
                                                       String orden) throws Exception {
        try {
//            String ordenLower = orden.toLowerCase();
//            if(!ordenLower.equals("asc") || !ordenLower.equals("desc")){
//                throw new Exception("El atributo 'orden' deber ser: [desc o asc]");
//            }
//            if ((seccion != "FEMENINO") || (seccion != "MASCULINO")) {
//                throw new Exception("En seccion debera ingresar uno de los siguientes campos: [FEMENINO, MASCULINO]");
//            }

            switch(orden) {
                case "asc":
                    return productoRepository.ordenarDetalleSinTipoAscendiente(id, seccion, categoria, talle);
                case "desc":
                    return productoRepository.ordenarDetalleSinTipoDescendiente(id, seccion, categoria, talle);
            }

            throw new Exception("En seccion debera seleccionar: [des o asc]");
        } catch (Exception e) {
            throw new RuntimeException("Ocurrio un error al ordenar sin tipo los detalles de producto[" + id +"]: " + e.getMessage());
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public List<DetalleProducto> ordenarDetalleSinTalle(Long id, String seccion,
                                                        String categoria, String tipo,
                                                        String orden) throws Exception {
        try {
//            String ordenLower = orden.toLowerCase();
//            if (!(tipo == "ROPA") || !(tipo == "ZAPATILLA")) {
//                throw new Exception("En seccion debera ingresar uno de los siguientes campos: [ROPA, ZAPATILLA]");
//            }
//            if(!ordenLower.equals("asc") || !ordenLower.equals("desc")){
//                throw new Exception("El atributo 'orden' deber ser: [desc o asc]");
//            }
//            if ((seccion != "FEMENINO") || (seccion != "MASCULINO")) {
//                throw new Exception("En seccion debera ingresar uno de los siguientes campos: [FEMENINO, MASCULINO]");
//            }
            switch(orden) {
                case "asc":
                    return productoRepository.ordenarDetalleSinTalleAscendiente(id, seccion, categoria, tipo);
                case "desc":
                    return productoRepository.ordenarDetalleSinTalleDescendiente(id, seccion, categoria, tipo);
            }

            throw new Exception("En seccion debera seleccionar: [des o asc]");
        } catch (Exception e) {
            throw new RuntimeException("Ocurrio un error al ordenar sin talle los detalles de producto[" + id +"]: " + e.getMessage());
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public List<DetalleProducto> ordenarDetallesPorProducto(Long id, String seccion, String categoria) throws Exception {
        try {
            Producto producto = productoRepository.findById(id)
                    .orElseThrow(() -> new Exception("Producto no encontrado con id: " + id));

//            if ((seccion != "FEMENINO") || (seccion != "MASCULINO")) {
//                throw new Exception("En seccion debera ingresar uno de los siguientes campos: [FEMENINO, MASCULINO]");
//            }
            return productoRepository.ordenarDetallesPorProducto(producto.getId(), seccion, categoria);
        } catch (Exception e) {
            throw new RuntimeException("Ocurrio un error al ordenar los detalles de producto[" + id +"]: " + e.getMessage());
        }
    };

    @Transactional(rollbackFor = Exception.class)
    public List<DetalleProducto> ordernarDetallesPorTalleDeProducto(Long id,
                                                                    String seccion,
                                                                    String categoria,
                                                                    String talle) throws Exception{
      try {
          Producto producto = productoRepository.findById(id)
                  .orElseThrow(() -> new Exception("Producto no encontrado con id: " + id));

//          if (!(seccion == "FEMENINO") || !(seccion == "MASCULINO")) {
//              throw new Exception("En seccion debera ingresar uno de los siguientes campos: [FEMENINO, MASCULINO]");
//          }
          return productoRepository.ordenarDetallesPorTalleDeProducto(
                  producto.getId(),
                  seccion,
                  categoria,
                  talle
          );
      } catch (Exception e) {
          throw new RuntimeException("Ocurrio un error al ordenar por talle los detalles de producto[" + id +"]: " +e.getMessage());
      }
    };

    @Transactional(rollbackFor = Exception.class)
    public List<DetalleProducto> ordenarDetallePorTipodeproducto(Long id,
                                                                 String seccion,
                                                                 String categoria,
                                                                 String tipo) throws Exception {
        try {
            Producto producto = productoRepository.findById(id)
                    .orElseThrow(() -> new Exception("Producto no encontrado con id: " + id));


//            if (!(seccion == "FEMENINO") || !(seccion == "MASCULINO")) {
//                throw new Exception("En seccion debera ingresar uno de los siguientes campos: [FEMENINO, MASCULINO]");
//            }
//            if (!(tipo == "ROPA") || !(tipo == "ZAPATILLA")) {
//                throw new Exception("En seccion debera ingresar uno de los siguientes campos: [ROPA, ZAPATILLA]");
//            }
            return productoRepository.ordenarDetallePorTipodeproducto(
                    producto.getId(),
                    seccion,
                    categoria,
                    tipo
            );
        } catch (Exception e) {
            throw new RuntimeException("Ocurrio un error al ordenar por tipoproducto los detalles de producto[" + id +"]: " + e.getMessage());
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public List<DetalleProducto> ordenarDetallePorPrecio(Long id,
                                                         String seccion,
                                                         String categoria,
                                                         String orden
                                                        ) throws Exception {
        try {
            Producto producto = productoRepository.findById(id)
                    .orElseThrow(() -> new Exception("Producto no encontrado con id: " + id));

//            if (!(seccion == "FEMENINO") || !(seccion == "MASCULINO")) {
//                throw new Exception("En seccion debera ingresar uno de los siguientes campos: [FEMENINO, MASCULINO]");
//            }
            switch (orden) {
                case "asc":
                    return productoRepository.ordenarDetallePorPrecioAscendente(producto.getId(), seccion, categoria);
                case "desc":
                    return productoRepository.ordenarDetallePorPrecioDescendente(producto.getId(), seccion, categoria);
                default:
                    throw new Exception("El orden debe ser: [ascendiente, descendiente]");

            }
        } catch (Exception e) {
            throw new RuntimeException("Ocurrio un error al ordenar por precio los detalles de producto[" + id +"]: " + e.getMessage());
        }
    }

    // ----------------------- METODOS PARA LOS ATRBUTOS DE PRODUCTO -----------------------
    // agregaron una categoria
    @Transactional
    public Producto asociarCategoria(Long idProducto, Categoria newCategoria) throws Exception {
        try {
            Producto producto = productoRepository.findById(idProducto)
                    .orElseThrow(() -> new Exception("Producto no encontrado con id: " + idProducto));

            if (producto.getCategoria() != null){
                throw new Exception("El producto " + producto.getNombre() + " tiene una categoria!");
            }
            producto.setCategoria(newCategoria);
            return productoRepository.save(producto);
        } catch (Exception ex) {
            throw new Exception("Ocurrio un error en el servicio (asociarCategoria): " + ex.getMessage());
        }

    }
    // metodo para sacar la categoria existente
    @Transactional
    public Producto desasocialCategoria(Long idProducto) throws Exception {
        try {
            Producto producto = productoRepository.findById(idProducto)
                    .orElseThrow(() -> new Exception("Producto no encontrado con id: " + idProducto));

            producto.setCategoria(null);
            return productoRepository.save(producto);
        } catch (Exception ex) {
            throw new Exception("Ocurrio un error en el servicio (desasocialProducto): " + ex.getMessage());
        }
    }

    ///  METODOS PARA DETALLEPRODUCTOS
    // metodos para agregar un detalle
    @Transactional
    public Producto agregarDetalleProducto(Long idProducto, DetalleProducto newDetalle) throws Exception {
        try {
            Producto producto = productoRepository.findById(idProducto)
                    .orElseThrow(() -> new Exception("Producto no encontrado con id: " + idProducto));
            producto.getDetallesProductos().add(newDetalle);
            return productoRepository.save(producto);
        } catch (Exception ex) {
            throw new Exception("Ocurrio un error en el servicio (agregarDetalleProducto): " + ex.getMessage());
        }

    }
    @Transactional
    public Producto sacarDetalleProducto(Long idProducto, DetalleProducto detalleEliminar) throws Exception {
        try {
            Producto producto = productoRepository.findById(idProducto)
                    .orElseThrow(() -> new Exception("Producto no encontrado con id: " + idProducto));
            producto.getDetallesProductos().removeIf(detalle -> detalle.getId() == detalleEliminar.getId());
            return productoRepository.save(producto);
        } catch (Exception ex) {
            throw new Exception("Ocurrio un error en el servicio (sacarDetalleProducto): " + ex.getMessage());
        }
    }
}