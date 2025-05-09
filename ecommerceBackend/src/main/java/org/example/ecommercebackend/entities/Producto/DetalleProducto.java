package org.example.ecommercebackend.entities.Producto;

<<<<<<< HEAD
=======
import com.fasterxml.jackson.annotation.JsonBackReference;
>>>>>>> 4aec04cf72a3a5ffaadc9a19f9d8ae41ff23ca2c
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.example.ecommercebackend.entities.Base;

@Entity
@Table(name = "detalle_producto")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DetalleProducto extends Base {

    @ManyToOne()
    @JoinColumn(name = "fk_talle")
    private Talles talledetalleProductos;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    @JsonBackReference
    private Producto producto;

    @ManyToOne()
    @JoinColumn(name = "fk_precio")
    private Precio precio;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "color")
    private String color;

    @Column(name = "estado")
    private Boolean estado;

<<<<<<< HEAD
    // relaciones
    @ManyToOne
    @JoinColumn(name = "fk_talle")
    private Talles talledetalleProductos;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    @JsonManagedReference
    private Producto producto;

    @OneToOne
    @JoinColumn(name = "fk_precio")
    private Precio precio;

    @OneToOne
=======
    @OneToOne()
>>>>>>> 4aec04cf72a3a5ffaadc9a19f9d8ae41ff23ca2c
    @JoinColumn(name = "fk_imagen_producto")
    private ImagenProducto imagenProducto;
}
