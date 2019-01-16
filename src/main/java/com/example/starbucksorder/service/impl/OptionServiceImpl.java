package com.example.starbucksorder.service.impl;

import com.example.starbucksorder.domain.Option;
import com.example.starbucksorder.domain.PersonalOption;
import com.example.starbucksorder.repository.OptionRepository;
import com.example.starbucksorder.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class OptionServiceImpl implements OptionService {


    @Autowired
    OptionRepository optionRepository;

    @Autowired
    PersonalOptionServiceImpl personalOptionService;


    @Override
    public void createOption(List<PersonalOption> personalOptions,Option option) {

        option.setPrice(calAmount(personalOptions));

        optionRepository.save(option);

        personalOptionService.addPersonalOption(personalOptions,option);

    }

    /*
    *
    * 옵션들의 총 금액을 계산
    * */
    private Integer calAmount(List<PersonalOption> personalOptions){

        Integer amount = 0;

        for(PersonalOption p : personalOptions){
            amount += p.getCount()*500;
        }

        return amount;

    }

    @Override
    public Option findOption(Long id){

        return optionRepository.findById(id).get();

    }

    @Override
    public void removeOption(Long id) {

        Option option = optionRepository.findById(id).get();

        optionRepository.delete(option);

    }
}
