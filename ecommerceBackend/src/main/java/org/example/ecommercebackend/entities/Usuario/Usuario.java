package org.example.ecommercebackend.entities.Usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.ecommercebackend.entities.Base;

@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario extends Base {

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "contraseña")
    private String contraseña;

    @Column(name = "rol")
    private org.example.ecommercebackend.entities.Usuario.Rol rol;

    @Column(name = "email")
    private String email;

    @Column(name = "dni")
    private Integer dni;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_usuario_direccion")
    private UsuarioDireccion usuarioDireccion;
}
