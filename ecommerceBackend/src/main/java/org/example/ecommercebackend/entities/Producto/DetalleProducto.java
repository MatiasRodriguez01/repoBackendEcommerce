package org.example.ecommercebackend.entities.Producto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.example.ecommercebackend.entities.Base;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "detalle_producto")
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
    @JsonBackReference("producto-detalle")
    private Producto producto;

    @OneToOne
    @JoinColumn(name = "fk_precio")
    private Precio precio;

    @OneToOne
    @JoinColumn(name = "fk_imagen_producto")
    private ImagenProducto imagenProducto;
}
