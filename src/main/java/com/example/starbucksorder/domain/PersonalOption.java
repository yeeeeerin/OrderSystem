package com.example.starbucksorder.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PERSONAL_OPTION")
public class PersonalOption {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSONAL_OPTION_SEQ_GENERATOR")
    @Column(name = "PERSONAL_OPTION_ID")
    @Id
    Long id;

    @Column
    String name;

    @Column
    Integer count;
}
