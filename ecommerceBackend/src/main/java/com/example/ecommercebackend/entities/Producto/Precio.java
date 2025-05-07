package org.example.ecommercebackend.entities.Producto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.ecommercebackend.entities.Base;

@Entity
@Table(name = "precios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Precio extends Base {

    @Column(name = "precio_compra")
    private Integer precioCompra;

    @Column(name = "precio_venta")
    private Integer precioVenta;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}) //no se si va remove ya que otro precio podria tener el mismo descuento
    private Descuento descuento;


}
