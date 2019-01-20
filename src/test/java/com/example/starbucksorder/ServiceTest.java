package com.example.starbucksorder;

import com.example.starbucksorder.domain.Category;
import com.example.starbucksorder.domain.Option;
import com.example.starbucksorder.domain.PersonalOption;
import com.example.starbucksorder.domain.Product;
import com.example.starbucksorder.domain.status.CategoryType;
import com.example.starbucksorder.domain.status.CupSize;
import com.example.starbucksorder.domain.status.CupType;
import com.example.starbucksorder.exception.coustomexception.AlreadyExistException;
import com.example.starbucksorder.service.impl.CategoryServiceImpl;
import com.example.starbucksorder.service.impl.OptionServiceImpl;
import com.example.starbucksorder.service.impl.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ServiceTest {

    @Autowired
    OptionServiceImpl optionService;

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    CategoryServiceImpl categoryService;



    @Test(expected = AlreadyExistException.class)
    public void productServiceEx(){

        Category category = new Category();
        category.setName("커피");
        category.setCategoryType(CategoryType.음료);
        categoryService.addCategory(category);


        Product product1 = new Product();
        Product product2 = new Product();

        product1.setName("아메");
        product2.setName("아메");

        productService.addProduct(product1,"커피");

        Product product = productService.findProduct(product1.getId());

        assertThat(product.getName(),is("아메"));

        productService.addProduct(product2,"커피");

    }



    @Test
    public void optioninsertTest(){
        PersonalOption p1 = new PersonalOption();
        PersonalOption p2 = new PersonalOption();

        p1.setName("shot");
        p1.setCount(2);

        p2.setName("shot");
        p2.setCount(4);

        List<PersonalOption> pList = new ArrayList<>();
        pList.add(p1);
        pList.add(p2);

        Option option = new Option();
        option.setCupSize(CupSize.GRANDE);
        option.setCupType(CupType.MUG);

        optionService.createOption(pList,option);

        Option option1 = optionService.findOption(option.getId());

        assertThat(option1.getPrice(),is(3000));


    }



}
