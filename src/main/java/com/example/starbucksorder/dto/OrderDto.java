package com.example.starbucksorder.dto;


import com.example.starbucksorder.domain.User;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto {

    User user;

    List<ProductDto> productDtos;

}
