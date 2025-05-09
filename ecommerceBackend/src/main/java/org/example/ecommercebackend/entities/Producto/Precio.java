package org.example.ecommercebackend.entities.Producto;

import jakarta.persistence.*;
import lombok.*;
import lombok.Builder;
import org.example.ecommercebackend.entities.Base;

@Entity
@Table(name = "precios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Precio extends Base {

    @Column(name = "precio_compra")
    private Integer precioCompra;

    @Column(name = "precio_venta")
    private Integer precioVenta;


    //@OneToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE}) //no se si va remove ya que otro precio podria tener el mismo descuent
    @OneToOne
    @JoinColumn(name = "fk_descuentos")
    private Descuento descuento;


}
  