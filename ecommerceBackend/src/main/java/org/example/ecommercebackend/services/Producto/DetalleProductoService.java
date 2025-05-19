package org.example.ecommercebackend.services.Producto;

import jakarta.transaction.Transactional;
import org.example.ecommercebackend.entities.Producto.*;
import org.example.ecommercebackend.repositories.Producto.DetalleProductoRepository;
import org.example.ecommercebackend.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleProductoService extends BaseService<DetalleProducto, Long> {

    @Autowired
    private DetalleProductoRepository detalleProductoRepository;

    public DetalleProductoService(DetalleProductoRepository detalleProductoRepository) {
        super(detalleProductoRepository);
    }

    // ----------------------- METODOS PARA LAS CONSULTAS DE LA BD -------------------------
    @org.springframework.transaction.annotation.Transactional(rollbackFor = Exception.class)
    public List<DetalleProducto> filtarDetalleProducto(String seccion,
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
                    return detalleProductoRepository.filtrarDetalleProductoAscendiente(seccion, categoria, talle, tipo);
                case "desc":
                    return detalleProductoRepository.filtrarDetalleProductoDescendiente(seccion, categoria, talle, tipo);
            }

            throw new Exception("En seccion debera seleccionar: [des o asc]");
        }   catch (Exception e) {
            throw new RuntimeException("Ocurrio un error al mostrar los detalles: " + e.getMessage());
        }
    }

    @org.springframework.transaction.annotation.Transactional(rollbackFor = Exception.class)
    public List<DetalleProducto> ordenarDetalleSinOrden(String seccion,
                                                        String categoria, String talle,
                                                        String tipo) throws Exception {
        try {

//            if ((seccion != "FEMENINO") || (seccion != "MASCULINO")) {
//                throw new Exception("En seccion debera ingresar uno de los siguientes campos: [FEMENINO, MASCULINO]");
//            }
//            if (!(tipo == "ROPA") || !(tipo == "ZAPATILLA")) {
//                throw new Exception("En seccion debera ingresar uno de los siguientes campos: [ROPA, ZAPATILLA]");
//            }
            return detalleProductoRepository.ordenarDetalleSinOrden(seccion, categoria, talle, tipo);
        } catch (Exception e) {
            throw new RuntimeException("Ocurrio un error al ordenar sin orden los detalles: " + e.getMessage());
        }
    }

    @org.springframework.transaction.annotation.Transactional(rollbackFor = Exception.class)
    public List<DetalleProducto> ordenarDetalleSinTipo(String seccion,
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
                    return detalleProductoRepository.ordenarDetalleSinTipoAscendiente(seccion, categoria, talle);
                case "desc":
                    return detalleProductoRepository.ordenarDetalleSinTipoDescendiente(seccion, categoria, talle);
            }

            throw new Exception("En seccion debera seleccionar: [des o asc]");
        } catch (Exception e) {
            throw new RuntimeException("Ocurrio un error al ordenar sin tipo los detalles: " + e.getMessage());
        }
    }

    @org.springframework.transaction.annotation.Transactional(rollbackFor = Exception.class)
    public List<DetalleProducto> ordenarDetalleSinTalle(String seccion,
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
                    return detalleProductoRepository.ordenarDetalleSinTalleAscendiente(seccion, categoria, tipo);
                case "desc":
                    return detalleProductoRepository.ordenarDetalleSinTalleDescendiente(seccion, categoria, tipo);
            }

            throw new Exception("En seccion debera seleccionar: [des o asc]");
        } catch (Exception e) {
            throw new RuntimeException("Ocurrio un error al ordenar sin talle los detalles: " + e.getMessage());
        }
    }

    @org.springframework.transaction.annotation.Transactional(rollbackFor = Exception.class)
    public List<DetalleProducto> ordenarDetallesPorProducto(String seccion, String categoria) throws Exception {
        try {
//            if ((seccion != "FEMENINO") || (seccion != "MASCULINO")) {
//                throw new Exception("En seccion debera ingresar uno de los siguientes campos: [FEMENINO, MASCULINO]");
//            }
            return detalleProductoRepository.ordenarDetallesPorProducto(seccion, categoria);
        } catch (Exception e) {
            throw new RuntimeException("Ocurrio un error al ordenar los detalles: " + e.getMessage());
        }
    };

    @org.springframework.transaction.annotation.Transactional(rollbackFor = Exception.class)
    public List<DetalleProducto> ordernarDetallesPorTalleDeProducto(String seccion,
                                                                    String categoria,
                                                                    String talle) throws Exception{
        try {
//          if (!(seccion == "FEMENINO") || !(seccion == "MASCULINO")) {
//              throw new Exception("En seccion debera ingresar uno de los siguientes campos: [FEMENINO, MASCULINO]");
//          }
            return detalleProductoRepository.ordenarDetallesPorTalleDeProducto(
                    seccion,
                    categoria,
                    talle
            );
        } catch (Exception e) {
            throw new RuntimeException("Ocurrio un error al ordenar por talle los detalles: " +e.getMessage());
        }
    };

    @org.springframework.transaction.annotation.Transactional(rollbackFor = Exception.class)
    public List<DetalleProducto> ordenarDetallePorTipodeproducto(String seccion,
                                                                 String categoria,
                                                                 String tipo) throws Exception {
        try {
//            if (!(seccion == "FEMENINO") || !(seccion == "MASCULINO")) {
//                throw new Exception("En seccion debera ingresar uno de los siguientes campos: [FEMENINO, MASCULINO]");
//            }
//            if (!(tipo == "ROPA") || !(tipo == "ZAPATILLA")) {
//                throw new Exception("En seccion debera ingresar uno de los siguientes campos: [ROPA, ZAPATILLA]");
//            }
            return detalleProductoRepository.ordenarDetallePorTipodeproducto(
                    seccion,
                    categoria,
                    tipo
            );
        } catch (Exception e) {
            throw new RuntimeException("Ocurrio un error al ordenar por tipoproducto los detalles: " + e.getMessage());
        }
    }

    @org.springframework.transaction.annotation.Transactional(rollbackFor = Exception.class)
    public List<DetalleProducto> ordenarDetallePorPrecio(String seccion,
                                                         String categoria,
                                                         String orden
    ) throws Exception {
        try {
//            if (!(seccion == "FEMENINO") || !(seccion == "MASCULINO")) {
//                throw new Exception("En seccion debera ingresar uno de los siguientes campos: [FEMENINO, MASCULINO]");
//            }
            switch (orden) {
                case "asc":
                    return detalleProductoRepository.ordenarDetallePorPrecioAscendente(seccion, categoria);
                case "desc":
                    return detalleProductoRepository.ordenarDetallePorPrecioDescendente(seccion, categoria);
                default:
                    throw new Exception("El orden debe ser: [ascendiente, descendiente]");

            }
        } catch (Exception e) {
            throw new RuntimeException("Ocurrio un error al ordenar por precio los detalles: " + e.getMessage());
        }
    }

    // -------------------------
    
    @Transactional
    public DetalleProducto agregarTalles(Long detalleId, Talles newTalle) throws Exception {
        try {
            DetalleProducto detalle = detalleProductoRepository.findById(detalleId)
                    .orElseThrow(() -> new Exception("DetalleProducto no encontrado con id: " + detalleId));


            detalle.getTallesDetalleProductos().add(newTalle);
            return detalleProductoRepository.save(detalle);
        } catch (Exception ex) {
            throw new Exception("Ocurrio un error en el servicio (agregarTalles): " + ex.getMessage());
        }
    }

    @Transactional
    public DetalleProducto sacarTalles(Long detalleId, Talles talleDelete) throws Exception {
        try {
            DetalleProducto detalle = detalleProductoRepository.findById(detalleId)
                    .orElseThrow(() -> new Exception("DetalleProducto no encontrado con id: " + detalleId));


            detalle.getTallesDetalleProductos().removeIf(talle -> talle.getId() == talleDelete.getId());
            return detalleProductoRepository.save(detalle);
        } catch (Exception ex) {
            throw new Exception("Ocurrio un error en el servicio (sacarTalles): " + ex.getMessage());
        }
    }

    // METODOS PARA PRODUCTO
    // Metodo para asocial un producto
    @Transactional
    public DetalleProducto asociarProducto(Long detalleId, Producto producto) throws Exception {
        try {
            DetalleProducto detalle = detalleProductoRepository.findById(detalleId)
                    .orElseThrow(() -> new Exception("DetalleProducto no encontrado con id: " + detalleId));

            if (detalle.getProducto() != null) {
                throw new Exception("Este detalle ya tiene un producto asociado");
            }
            detalle.setProducto(producto);
            return detalleProductoRepository.save(detalle);
        } catch (Exception ex) {
            throw new Exception("Ocurrio un error en el servicio (asociarProducto): " + ex.getMessage());
        }

    }
    // metodo para desasocial un producto
    @Transactional
    public DetalleProducto desasociarProducto(Long detalleId) throws Exception {
        try {
            DetalleProducto detalle = detalleProductoRepository.findById(detalleId)
                    .orElseThrow(() -> new Exception("DetalleProducto no encontrado con id: " + detalleId));

            detalle.setProducto(null);
            return detalleProductoRepository.save(detalle);
        } catch (Exception ex) {
            throw new Exception("Ocurrio un error en el servicio (desasocialProducto): " + ex.getMessage());
        }

    }

    // METODOS PARA PRECIO
    // metodos para asocial un precio
    @Transactional
    public DetalleProducto asociarPrecio(Long detalleId, Precio precio) throws Exception {
        try {
            DetalleProducto detalle = detalleProductoRepository.findById(detalleId)
                    .orElseThrow(() -> new Exception("DetalleProducto no encontrado con id: " + detalleId));

            if (detalle.getPrecio() != null) {
                throw new Exception("Este detalle ya tiene un precio asociado");
            }
            detalle.setPrecio(precio);
            return detalleProductoRepository.save(detalle);
        } catch (Exception ex) {
            throw new Exception("Ocurrio un error en el servicio (asocialPrecio): " + ex.getMessage());
        }
    }
    // metodo para desasocial un precio
    @Transactional
    public DetalleProducto desasociarPrecio(Long detalleId) throws Exception {
        try {
            DetalleProducto detalle = detalleProductoRepository.findById(detalleId)
                    .orElseThrow(() -> new Exception("DetalleProducto no encontrado con id: " + detalleId));

            detalle.setPrecio(null);
            return detalleProductoRepository.save(detalle);
        } catch (Exception ex) {
            throw new Exception("Ocurrio un error en el servicio (desasocialPrecio): " + ex.getMessage());
        }

    }

    // METODOS PARA IMAGEN___PRODUCTO
    // metodo para asociar una imagen
    @Transactional
    public DetalleProducto asocialImagen(Long detalleId, ImagenProducto imagen) throws Exception {
        try {
            DetalleProducto detalle = detalleProductoRepository.findById(detalleId)
                    .orElseThrow(() -> new Exception("DetalleProducto no encontrado con id: " + detalleId));
            if (detalle.getImagenProducto() != null) {
                throw new Exception("El detalle " + detalle.getId() + " ya tiene una imagen asociada");
            }
            detalle.setImagenProducto(imagen);
            return detalleProductoRepository.save(detalle);
        } catch (Exception ex) {
            throw new Exception("Ocurrio un error en el servicio (asocialImagen): " + ex.getMessage());
        }

    }
    // metodo para eliminar imagen
    public DetalleProducto desasocialImagen(Long detalleId) throws Exception {
        try {
            DetalleProducto detalle = detalleProductoRepository.findById(detalleId)
                    .orElseThrow(() -> new Exception("DetalleProducto no encontrado con id: " + detalleId));

            detalle.setImagenProducto(null);
            return detalleProductoRepository.save(detalle);
        } catch (Exception ex) {
            throw new Exception("Ocurrio un error en el servicio (desasocialImagen): " + ex.getMessage());
        }

    }
}