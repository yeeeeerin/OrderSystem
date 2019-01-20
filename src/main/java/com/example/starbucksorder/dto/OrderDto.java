package com.example.starbucksorder.dto;


import com.example.starbucksorder.domain.Option;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto {

    List<ProductDto> productDtos;


}
