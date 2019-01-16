package com.example.starbucksorder.service;

import com.example.starbucksorder.domain.Option;
import com.example.starbucksorder.domain.PersonalOption;

import java.util.List;

public interface PersonalOptionService {

    void addPersonalOption(List<PersonalOption> personalOptions, Option option);

    void removePersonalOption(Long id);


}
