package com.example.starbucksorder.repository;

import com.example.starbucksorder.domain.OnOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OnOrderRepository extends JpaRepository<OnOrder,Long> {
}
