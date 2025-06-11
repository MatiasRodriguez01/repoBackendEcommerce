package org.example.ecommercebackend.entities.Usuario;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import org.example.ecommercebackend.entities.Base;
import org.example.ecommercebackend.entities.Producto.Descuento;
import org.example.ecommercebackend.entities.Producto.DetalleProducto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orden_compra")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrdenCompra extends Base {


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_usuario_direccion")
    private UsuarioDireccion usuarioDireccion;

    @Column(name = "total")
    private Double total;


    @Column(name = "fecha_compra")
    private LocalDate fechaCompra;


    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_descuento")
    private Descuento descuento;

    @Builder.Default
    @OneToMany(mappedBy = "ordenCompra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrdenCompraDetalle> detalles = new ArrayList<>();

    @OneToMany()
    private List<DetalleProducto> detallesProductos = new ArrayList<>();
}
