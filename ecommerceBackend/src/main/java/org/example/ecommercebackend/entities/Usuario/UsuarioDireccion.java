package org.example.ecommercebackend.entities.Usuario;

import jakarta.persistence.*;
import lombok.*;
import org.example.ecommercebackend.entities.Base;

@Entity
@Table(name = "usuario_direccion")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDireccion extends Base {

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_direccion")
    private Direccion direccion;
}
