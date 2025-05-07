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
@Table(name = "producto")
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

    @Column(name = "tipo_producto")
    private TipoProducto tipoProducto;

    @Column(name = "sexo")
    private String sexo;

    @Builder.Default
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleProducto> detallesProductos = new ArrayList<>();
}
