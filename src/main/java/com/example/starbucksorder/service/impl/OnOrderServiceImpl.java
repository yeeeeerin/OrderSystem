package com.example.starbucksorder.service.impl;

import com.example.starbucksorder.domain.OnOrder;
import com.example.starbucksorder.domain.Option;
import com.example.starbucksorder.domain.Product;
import com.example.starbucksorder.domain.User;
import com.example.starbucksorder.domain.status.OrderStatus;
import com.example.starbucksorder.dto.OrderDto;
import com.example.starbucksorder.dto.ProductDto;
import com.example.starbucksorder.repository.OnOrderRepository;
import com.example.starbucksorder.repository.ProductRepository;
import com.example.starbucksorder.repository.UserRepository;
import com.example.starbucksorder.service.OnOrderService;
import com.example.starbucksorder.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class OnOrderServiceImpl implements OnOrderService {

    @Autowired
    OrderProductService orderProductService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OptionServiceImpl optionService;

    @Autowired
    OnOrderRepository onOrderRepository;

    @Autowired
    UserRepository userRepository;

    /*
    * order 메소드에서 모든 주문과 관련된 동작 실행
    * todo 토큰은 어떻게?;;
    * */
    @Override
    @Transactional
    public void order(Long userId, OrderDto orderDto) {

        User user = userRepository.findById(userId).get();

        OnOrder onOrder = new OnOrder();
        onOrder.setOrderStatus(OrderStatus.WAITING_CONFIEM);
        onOrder.setPrice(calcAmount(orderDto.getProductDtos()));
        onOrder.setUser(user);

        onOrderRepository.save(onOrder);


        for(ProductDto productDto:orderDto.getProductDtos()) {

            Product product = productRepository.findByName(productDto.getName()).get();
            Option option = productDto.getOption();

            optionService.createOption(productDto.getPersonalOptions(),option);
            orderProductService.addOrderProduct(onOrder, product, option);
        }


    }

    /*
    *
    * 총 금액을 계산해주는 메소드
    * */
    //@Transactional(readOnly = true)
    public Integer calcAmount(List<ProductDto> productDtos){

        int amount = 0;

        for(ProductDto productDto : productDtos){
            amount += (productDto.getPrice()*productDto.getCount());

            amount += (productDto.getOption().getPrice());
        }


        return amount;
    }

    @Override
    @Transactional
    public void cancelOrder(Long orderId) {

        OnOrder onOrder = onOrderRepository.findById(orderId).get();

        onOrderRepository.delete(onOrder);

    }

    @Override
    @Transactional
    public void findOrder() {

    }
}
