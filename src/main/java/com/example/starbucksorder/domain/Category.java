package com.example.starbucksorder.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CATEGORY")
public class Category {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGOTY_SEQ_GENERATOR")
    @Column(name = "CATEGORY_ID")
    @Id
    Long id;

    @Column
    String name;
}
