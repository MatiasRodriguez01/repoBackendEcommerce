package org.example.ecommercebackend.entities.Producto;

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
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
//@Audited preguntar si hacer auditoria
public class Producto extends Base {

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "tipo_producto")
    private TipoProducto tipoProducto;

    @ManyToOne()
    @JoinColumn(name = "fk_categoria")
    private Categoria categoria;

    @Builder.Default
    @OneToMany(mappedBy = "producto", cascade = CascadeType.MERGE, orphanRemoval = true)
    //@JoinColumn(name = "fk_destalles_productos")
    private List<DetalleProducto> detallesProductos = new ArrayList<>();

    public void addDetalleProducto(DetalleProducto detalleProducto) {
        detallesProductos.add(detalleProducto);
        detalleProducto.setProducto(this);

    }
}
