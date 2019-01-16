package com.example.starbucksorder;

import com.example.starbucksorder.domain.Option;
import com.example.starbucksorder.domain.PersonalOption;
import com.example.starbucksorder.domain.status.CupSize;
import com.example.starbucksorder.domain.status.CupType;
import com.example.starbucksorder.service.impl.OptionServiceImpl;
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
