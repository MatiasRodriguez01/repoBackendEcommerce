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

    //esta relacion es many to one y ver si hacer bidireccional o no y si no ver cual entidad sera propietaria (creo que esta es mejor que sea bidireccional)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_orden_compra")
    private org.example.ecommercebackend.entities.Usuario.OrdenCompra ordenCompra;

    //poner bien la relacion y ver bien cual relacion conviene que sea la propietaria
    private Long idProducto;

    @Column(name = "cantidad")
    private Integer cantidad;



}
