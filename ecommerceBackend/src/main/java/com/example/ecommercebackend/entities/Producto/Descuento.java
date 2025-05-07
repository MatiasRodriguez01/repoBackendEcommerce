package org.example.ecommercebackend.entities.Producto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.ecommercebackend.entities.Base;

import java.util.Date;

@Entity
@Table(name = "descuento_producto")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Descuento extends Base {


    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;

}
