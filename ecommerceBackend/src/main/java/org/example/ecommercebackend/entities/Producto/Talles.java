package org.example.ecommercebackend.entities.Producto;

import jakarta.persistence.*;
import lombok.*;
import org.example.ecommercebackend.entities.Base;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "talles")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Talles extends Base {

    @Column(name = "talle")
    private String talle;

//    @Builder.Default
//    @OneToMany(mappedBy = "talledetalleProductos",cascade = CascadeType.ALL, orphanRemoval = true)
//    //@JoinColumn(name = "fk_detalles_productos")
//    private List<DetalleProducto> detallesProductos = new ArrayList<>();

//    public void addDetalleProducto(DetalleProducto detalleProducto) {
//        detallesProductos.add(detalleProducto);
//    }

}