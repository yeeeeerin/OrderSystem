package com.example.starbucksorder.domain;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "PRODUCT_TYPE")
public class ProductType {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_TYPE_SEQ_GENERATOR")
    @Column(name = "PRODUCT_TYPE_ID")
    @Id
    Long id;

    @Column
    String name;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    Category category;
}
