package org.example.ecommercebackend.entities.Producto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
