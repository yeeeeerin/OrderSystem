package com.example.starbucksorder.domain;


import com.example.starbucksorder.domain.status.OrderStatus;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class OnOrder {
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ORDER_SEQ_GENERATOR")
    @Id
    Long id;

    @Enumerated(EnumType.STRING)
    OrderStatus orderStatus;

    /*
    @Column
    String billingNo;
    */

    @Column
    Integer price;

    /*
    @Column
    String payAuthToken;
    */

    @CreatedDate
    @Column
    Date orderTime;

    @ManyToOne
    User user;


}
