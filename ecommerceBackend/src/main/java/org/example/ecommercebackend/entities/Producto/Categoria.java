package org.example.ecommercebackend.entities.Producto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import org.example.ecommercebackend.entities.Base;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorias")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Categoria extends Base {

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "categoria_padre_id")
    private Categoria categoriaPadre;

    @Builder.Default
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<Producto> productos = new ArrayList<>();

    public void addProducto(Producto producto) {
        productos.add(producto);
        producto.setCategoria(this);
    }

}


