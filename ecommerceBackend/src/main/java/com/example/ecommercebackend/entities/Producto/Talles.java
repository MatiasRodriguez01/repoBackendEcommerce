package org.example.ecommercebackend.entities.Producto;

import org.example.ecommercebackend.entities.Producto.DetalleProducto;

import jakarta.persistence.*;
import lombok.*;
import org.example.ecommercebackend.entities.Base;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "talles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Talles extends Base {

    @Column(name = "talle")
    private String talle;

    @Builder.Default
    @OneToMany(mappedBy = "talledetalleProductos",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleProducto> detallesProductos = new ArrayList<>();

    public void addDetalleProducto(DetalleProducto detalleProducto) {
        detallesProductos.add(detalleProducto);
        detalleProducto.setTalledetalleProductos(this);
    }
}