package org.example.ecommercebackend.entities.Producto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import org.example.ecommercebackend.entities.Base;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "productos")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Producto extends Base {

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne()
    @JoinColumn(name = "fk_categoria")
    @JsonIgnoreProperties("productos")
    private Categoria categoria;

    @Column(name = "seccion")
    @Enumerated(EnumType.STRING)
    private Seccion seccion;

    @Column(name = "tipo_producto")
    @Enumerated(EnumType.STRING)
    private TipoProducto tipoProducto;

    @Builder.Default
    @OneToMany(mappedBy = "producto", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<DetalleProducto> detallesProductos = new ArrayList<>();


    public void addDetalleProducto(DetalleProducto detalleProducto) {
        detallesProductos.add(detalleProducto);
        detalleProducto.setProducto(this);

    }
}
