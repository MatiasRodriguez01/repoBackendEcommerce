package org.example.ecommercebackend.entities.Producto;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import org.example.ecommercebackend.entities.Base;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "detalle_producto")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DetalleProducto extends Base {


    @Builder.Default
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "fk_talle",
            joinColumns = @JoinColumn(name = "id_detalle"),
            inverseJoinColumns =@JoinColumn(name = "id_talle")
    )
    private List<Talles> tallesDetalleProductos = new ArrayList<>();

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "color")
    private String color;

    @Column(name = "estado")
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @OneToOne
    @JoinColumn(name = "fk_precio")
    private Precio precio;

    @OneToOne
    @JoinColumn(name = "fk_imagen_producto")
    private ImagenProducto imagenProducto;

}

