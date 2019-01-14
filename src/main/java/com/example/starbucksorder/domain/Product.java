package com.example.starbucksorder.domain;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PRODUCT")
public class Product {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SEQ_GENERATOR")
    @Column(name = "PRODUCT_ID")
    @Id
    Long id;

    @Column
    String name;

    @Column
    Integer price;

    @Column
    String caption;


    @ManyToOne
    @JoinColumn(name = "OPTION_ID")
    Option option;


    @ManyToOne
    @JoinColumn(name = "PRODUCT_TYPE_ID")
    ProductType productType;

}
