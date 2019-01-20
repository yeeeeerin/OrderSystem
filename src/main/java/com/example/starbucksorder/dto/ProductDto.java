package com.example.starbucksorder.dto;

import com.example.starbucksorder.domain.Option;
import com.example.starbucksorder.domain.PersonalOption;
import lombok.Data;

import java.util.List;

@Data
public class ProductDto {

    Long id;

    String name;

    Integer price;

    Integer count;

    Option option;

    List<PersonalOption> personalOptions;

}
