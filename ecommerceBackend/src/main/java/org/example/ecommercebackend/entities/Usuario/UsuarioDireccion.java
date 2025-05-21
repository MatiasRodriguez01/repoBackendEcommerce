package org.example.ecommercebackend.entities.Usuario;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
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
