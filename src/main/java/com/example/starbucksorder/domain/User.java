package com.example.starbucksorder.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "USER_SEQ_GENERATOR")
    Long id;

    @Column(nullable = false, unique = true)
    String name;

}
