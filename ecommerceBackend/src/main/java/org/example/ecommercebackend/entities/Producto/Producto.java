package org.example.ecommercebackend.entities.Producto;

<<<<<<< HEAD
=======
import com.fasterxml.jackson.annotation.JsonBackReference;
>>>>>>> 4aec04cf72a3a5ffaadc9a19f9d8ae41ff23ca2c
import com.fasterxml.jackson.annotation.JsonManagedReference;
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


    @ManyToOne()
    @JoinColumn(name = "fk_categoria")
    @JsonBackReference
    private Categoria categoria;

    @Column(name = "sexo")
    private String sexo;


    @Column(name = "tipo_producto")
    private TipoProducto tipoProducto;

    @Builder.Default
    @OneToMany(mappedBy = "producto", cascade = CascadeType.MERGE, orphanRemoval = true)
    @JsonManagedReference
<<<<<<< HEAD
    //@JoinColumn(name = "fk_destalles_productos")
=======
>>>>>>> 4aec04cf72a3a5ffaadc9a19f9d8ae41ff23ca2c
    private List<DetalleProducto> detallesProductos = new ArrayList<>();

    public void addDetalleProducto(DetalleProducto detalleProducto) {
        detallesProductos.add(detalleProducto);
        detalleProducto.setProducto(this);

    }
}
