package com.example.starbucksorder.domain;

import com.example.starbucksorder.domain.status.CategoryType;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "CATETORY")
public class Category {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATETORY_SEQ_GENERATOR")
    @Column(name = "CATETORY_ID")
    @Id
    Long id;

    @Column
    String name;

    @Enumerated(EnumType.STRING)
    CategoryType categoryType;

}
