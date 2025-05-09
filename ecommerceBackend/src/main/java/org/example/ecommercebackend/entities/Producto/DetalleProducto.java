package org.example.ecommercebackend.entities.Producto;

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

    // atributos
    @Column(name = "stock")
    private Integer stock;

    @Column(name = "color")
    private String color;

    @Column(name = "estado")
    private Boolean estado;

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
    @JoinColumn(name = "fk_imagen_producto")
    private ImagenProducto imagenProducto;
}
