package com.example.starbucksorder.repository;

import com.example.starbucksorder.domain.PersonalOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonalOptionRepository extends JpaRepository<PersonalOption,Long> {

    Optional<PersonalOption> findByName(String name);

}
