package com.assignment.foodshalaBackend.repo;

import com.assignment.foodshalaBackend.models.Cart;
import com.assignment.foodshalaBackend.models.Food;
import com.assignment.foodshalaBackend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    Optional<Cart> findByUsersAndFood(Users users, Food food);
    List<Cart> findByUsersAndFood_Active(Users u,int a);
    void deleteByCartid(Long id);
    List<Cart> findAllByUsers(Users u);
}
