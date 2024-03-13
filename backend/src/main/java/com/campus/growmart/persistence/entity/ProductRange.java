package com.campus.growmart.persistence.entity;


import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "gama_producto")
public class ProductRange {

    @Id
    @Column(name = "gama", length = 50)
    private String range;

    @Column(name = "descripcion_texto", columnDefinition = "TEXT")
    private String textDescription;

    @Column(name = "descripcion_html", columnDefinition = "TEXT")
    private String htmlDescription;

    @Column(name = "imagen", length = 256)
    private String image;

    @OneToMany(mappedBy = "range", cascade = CascadeType.ALL)
    private List<Product> productList;

}
