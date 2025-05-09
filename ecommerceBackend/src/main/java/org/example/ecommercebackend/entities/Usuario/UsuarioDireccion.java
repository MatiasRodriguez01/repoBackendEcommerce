package org.example.ecommercebackend.entities.Usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.ecommercebackend.entities.Base;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario_direccion")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDireccion extends Base { //ES NECESARIO USUARIODIRECCION SI YA TENEMOS USUARIO Y DIRECCIONES?

    //PONER RELACION ONE TO ONE A USUARIO BIEN
    private Long idUsuario;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Direccion> direcciones = new ArrayList<Direccion>();
}
