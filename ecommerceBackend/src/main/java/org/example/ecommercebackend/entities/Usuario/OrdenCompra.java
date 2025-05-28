package org.example.ecommercebackend.entities.Usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.ecommercebackend.entities.Base;
import org.example.ecommercebackend.entities.Producto.Descuento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orden_compra")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrdenCompra extends Base {



    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_usuario_direccion")
    private UsuarioDireccion usuarioDireccion;

    @Column(name = "total")
    private Integer total;


    @Column(name = "fecha_compra")
    private Date fechaCompra;


    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_descuento")
    private Descuento descuento;

    @OneToMany(mappedBy = "ordenCompra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrdenCompraDetalle> detalles = new ArrayList<>();
}
