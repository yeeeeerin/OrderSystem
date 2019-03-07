package com.example.starbucksorder.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class OrderProduct {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CART_SEQ_GENERATOR")
    @Id
    Long id;

    @ManyToOne
    OnOrder onOrder;

    @ManyToOne
    Product product;

    @ManyToOne
    @JoinColumn(name = "OPTION_ID")
    Option option;
}
