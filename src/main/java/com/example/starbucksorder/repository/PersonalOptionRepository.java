package com.example.starbucksorder.repository;

import com.example.starbucksorder.domain.PersonalOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalOptionRepository extends JpaRepository<PersonalOption,Long> {
}
