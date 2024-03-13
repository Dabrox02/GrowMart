package com.campus.growmart.persistence.entity;


import jakarta.persistence.*;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "producto")
public class Product implements Serializable {


    @Id
    @Column(name = "codigo_producto", length = 15, nullable = false)
    private String productCode;

    @Column(name = "nombre", length = 70, nullable = false)
    private String name;


    @ManyToOne
    @JoinColumn(name = "gama", referencedColumnName = "gama" ,  nullable = false)
    private ProductRange range;


    @Column(name = "dimensiones", length = 25)
    private String dimensions;

    @Column(name = "proveedor", length = 50)
    private String supplier;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String description;

    @Column(name = "cantidad_en_stock", nullable = false)
    private Short stock;

    @Column(name = "precio_venta", precision = 15, scale = 2, nullable = false)
    private BigDecimal salePrice;

    @Column(name = "precio_proveedor", precision = 15, scale = 2)
    private BigDecimal supplierPrice;

    @OneToMany(mappedBy = "id.product", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetailList;



}
