package com.assignment.foodshalaBackend.repo;

import com.assignment.foodshalaBackend.models.OrderHistory;
import com.assignment.foodshalaBackend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory,Long> {
    List<OrderHistory> findAllByUsers(Users users);

}
