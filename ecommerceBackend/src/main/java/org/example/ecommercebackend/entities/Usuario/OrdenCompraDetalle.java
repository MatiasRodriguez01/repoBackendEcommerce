package org.example.ecommercebackend.entities.Usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.ecommercebackend.entities.Base;

@Entity
@Table(name = "orden_compra_detalle")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrdenCompraDetalle extends Base {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_orden_compra")
    private OrdenCompra ordenCompra;


    private Long idProducto;

    @Column(name = "cantidad")
    private Integer cantidad;



}
