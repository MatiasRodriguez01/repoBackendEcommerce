package org.example.ecommercebackend.entities.Usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.ecommercebackend.entities.Base;
import org.example.ecommercebackend.entities.Producto.Producto;

@Entity
@Table(name = "orden_compra_detalle")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrdenCompraDetalle extends Base {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_orden_compra")
    private OrdenCompra ordenCompra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_producto")
    private Producto producto;


    @Column(name = "cantidad")
    private Integer cantidad;

}
