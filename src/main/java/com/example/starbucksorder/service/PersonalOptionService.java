package com.example.starbucksorder.service;

import com.example.starbucksorder.domain.PersonalOption;

public interface PersonalOptionService {

    void addPersonalOption(PersonalOption personalOption);

    void removePersonalOption(Long id);


}
