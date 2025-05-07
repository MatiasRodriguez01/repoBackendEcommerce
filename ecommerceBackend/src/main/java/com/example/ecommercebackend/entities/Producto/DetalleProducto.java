package org.example.ecommercebackend.entities.Producto;

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

    @Column(name = "stock")
    private Number stock;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "fk_precio")
    private Precio precio;

    @Column(name = "color")
    private String color;

    @Column(name = "estado")
    private Boolean estado;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "fk_imagen_producto")
    private ImagenProducto ImagenProducto;
}
