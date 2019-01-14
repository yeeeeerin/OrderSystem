package com.example.starbucksorder.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "USER_SEQ_GENERATOR")
    Long id;

    @Column
    String name;

}
