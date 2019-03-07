package com.example.starbucksorder.domain;


import com.example.starbucksorder.domain.status.OrderStatus;
import com.example.starbucksorder.event.OrderEvent;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class OnOrder extends AbstractAggregateRoot {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ_GENERATOR")
    @Id
    Long id;

    @Enumerated(EnumType.STRING)
    OrderStatus orderStatus;

    /*
    String billingNo;
    */

    Integer price;

    /*
    String payAuthToken;
    */

    @CreatedDate
    Date orderTime;

    @ManyToOne
    User user;

    @OneToMany(mappedBy = "id")
    OrderProduct orderProduct;

    public OnOrder event(){
        this.registerEvent(new OrderEvent(this));
        return this;
    }


}
