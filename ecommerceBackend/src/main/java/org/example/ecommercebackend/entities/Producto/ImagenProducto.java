package org.example.ecommercebackend.entities.Producto;

import jakarta.persistence.*;
import lombok.*;
import org.example.ecommercebackend.entities.Base;

@Entity
@Table(name = "imagen_producto")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ImagenProducto extends Base {


    @Column(name = "url")
    private String url;

    @Column(name = "alt")
    private String alt;



}
