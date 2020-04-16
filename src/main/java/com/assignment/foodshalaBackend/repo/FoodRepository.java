package com.assignment.foodshalaBackend.repo;

import com.assignment.foodshalaBackend.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findAll();
    List<Food> findAllByFoodprice(long price);
    List<Food> findAllByFoodtype(String foodtype);
    Food findByFid(long id);
}
