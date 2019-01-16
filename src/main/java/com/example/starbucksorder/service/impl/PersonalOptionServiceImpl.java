package com.example.starbucksorder.service.impl;

import com.example.starbucksorder.domain.Option;
import com.example.starbucksorder.domain.PersonalOption;
import com.example.starbucksorder.exception.coustomexception.AlreadyExistException;
import com.example.starbucksorder.repository.PersonalOptionRepository;
import com.example.starbucksorder.service.PersonalOptionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PersonalOptionServiceImpl implements PersonalOptionService {


    @Autowired
    PersonalOptionRepository personalOptionRepository;

    @Override
    public void addPersonalOption(List<PersonalOption> personalOptions, Option option) {

        for(PersonalOption p:personalOptions) {
            Optional<PersonalOption> optionalPersonalOption =
                    personalOptionRepository.findByName(p.getName());

            if (!optionalPersonalOption.isEmpty()) {
                throw new AlreadyExistException("이미 존재하는 퍼스널 옵션입니다.");
            }

            p.setOption(option);

            personalOptionRepository.save(p);
        }

    }

    @Override
    public void removePersonalOption(Long id) {

        PersonalOption personalOption = personalOptionRepository.findById(id).get();

        personalOptionRepository.delete(personalOption);

    }
}
