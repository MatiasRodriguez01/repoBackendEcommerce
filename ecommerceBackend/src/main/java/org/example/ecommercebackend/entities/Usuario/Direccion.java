package org.example.ecommercebackend.entities.Usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.ecommercebackend.entities.Base;

@Entity
@Table(name = "direcciones")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Direccion extends Base {

    @Column(name = "localidad")
    private String localidad;

    @Column(name = "pais")
    private String pais;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "departamento")
    private String departamento;

}
