package org.example.ecommercebackend.entities.Usuario;

import jakarta.persistence.*;
import lombok.*;
import org.example.ecommercebackend.entities.Base;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "direcciones")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Direccion extends Base {

    @Column(name = "localidad")
    private String localidad;

    @Column(name = "pais")
    private String pais;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "nombre_calle")
    private String nombreCalle;

    @Column(name = "numeracion")
    private Integer numeracion;

    @Builder.Default
    @OneToMany(mappedBy = "direccion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UsuarioDireccion> usuarios = new ArrayList<>();
}
