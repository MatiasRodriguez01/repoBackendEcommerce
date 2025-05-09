package org.example.ecommercebackend.entities.Usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.ecommercebackend.entities.Base;

import java.util.Date;

@Entity
@Table(name = "orden_compra")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrdenCompra extends Base {



    @ManyToOne(cascade = CascadeType.PERSIST) //esto va a usuario direccion para tener la direccion desde donde se pidio?
    @JoinColumn(name = "fk_usuario_direccion")
    private UsuarioDireccion usuarioDireccion;

    @Column(name = "total")
    private Integer total;

    @Column(name = "descuento")
    private Integer descuento; //poner id del descuento?

    @Column(name = "fecha_compra")
    private Date fechaCompra;

    @Column(name = "direccion_envio") //aca iria la direccion de tipo direccion?
    private String direccionEnvio;
}
