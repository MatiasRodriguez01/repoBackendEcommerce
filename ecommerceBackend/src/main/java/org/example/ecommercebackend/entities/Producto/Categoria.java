package org.example.ecommercebackend.entities.Producto;

<<<<<<< HEAD
=======
import com.fasterxml.jackson.annotation.JsonBackReference;
>>>>>>> 4aec04cf72a3a5ffaadc9a19f9d8ae41ff23ca2c
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Builder.Default
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.MERGE, orphanRemoval = true)
    @JsonManagedReference
    private List<Producto> productos = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "categoria_padre_id")
    @JsonManagedReference
    private Categoria categoriaPadre;

<<<<<<< HEAD
    @Builder.Default
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.MERGE, orphanRemoval = true)
    @JsonManagedReference
    private List<Producto> productos = new ArrayList<>();

=======
>>>>>>> 4aec04cf72a3a5ffaadc9a19f9d8ae41ff23ca2c
    public void addProducto(Producto producto) {
        productos.add(producto);
        producto.setCategoria(this);
    }

}


