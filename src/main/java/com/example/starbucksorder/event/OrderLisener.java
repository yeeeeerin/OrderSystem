package com.example.starbucksorder.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderLisener  {

    @EventListener
    public void onApplicationEvent(OrderEvent event){
        log.info("order!" + event.getOnOrder().getOrderStatus());
    }

}
