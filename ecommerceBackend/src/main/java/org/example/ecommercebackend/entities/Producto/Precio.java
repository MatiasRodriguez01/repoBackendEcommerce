package org.example.ecommercebackend.entities.Producto;

import jakarta.persistence.*;
import lombok.*;
import lombok.Builder;
import org.example.ecommercebackend.entities.Base;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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


    @ManyToOne() //no se si va remove ya que otro precio podria tener el mismo descuento
    @JoinColumn(name = "descuento_id", unique = false)
    private Descuento descuento;


}
  