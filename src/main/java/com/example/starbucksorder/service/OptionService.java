package com.example.starbucksorder.service;

import com.example.starbucksorder.domain.Option;
import com.example.starbucksorder.domain.PersonalOption;
import lombok.extern.java.Log;

import java.util.List;

public interface OptionService {


    void createOption(List<PersonalOption> personalOptions, Option option);

    void removeOption(Long id);

}
