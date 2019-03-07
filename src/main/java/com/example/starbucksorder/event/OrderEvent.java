package com.example.starbucksorder.event;

import com.example.starbucksorder.domain.OnOrder;
import com.example.starbucksorder.dto.OrderDto;
import org.springframework.context.ApplicationEvent;

public class OrderEvent extends ApplicationEvent {

    private final OnOrder onOrder;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public OrderEvent(Object source) {
        super(source);
        this.onOrder = (OnOrder) source;
    }

    public OnOrder getOnOrder(){
        return onOrder;
    }
}
