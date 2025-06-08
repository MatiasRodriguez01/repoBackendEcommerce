package org.example.ecommercebackend.entities.Producto;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import org.example.ecommercebackend.entities.Base;

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
//@Audited preguntar si hacer auditoria
public class Producto extends Base {

    @Column(name = "nombre")
    private String nombre;


    @ManyToOne()
    @JoinColumn(name = "fk_categoria")
    private Categoria categoria;

    @Column(name = "seccion")
    @Enumerated(EnumType.STRING)
    private Seccion seccion;

    @Column(name = "tipo_producto")
    @Enumerated(EnumType.STRING)
    private TipoProducto tipoProducto;

    @Builder.Default
    @OneToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "detalles_de_producto",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns =@JoinColumn(name = "id_detalle")
    )
    private List<DetalleProducto> detallesProductos = new ArrayList<>();

    public void addDetalleProducto(DetalleProducto detalleProducto) {
        detallesProductos.add(detalleProducto);
        detalleProducto.setProducto(this);

    }
}
