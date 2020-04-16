package com.assignment.foodshalaBackend.controller;

import com.assignment.foodshalaBackend.models.OrderHistory;
import com.assignment.foodshalaBackend.repo.OrderHistoryRepository;
import com.assignment.foodshalaBackend.service.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/orderhistory")
public class OrderHistoryController {
    @Autowired
    CurrentUserService currentUserService;
    @Autowired
    private OrderHistoryRepository orderHistoryRepository;

    //get All orders
    @RequestMapping(value = "/orders",method = RequestMethod.GET)
    public List<OrderHistory> ordersDisplay(){
        return orderHistoryRepository.findAll();
    }

}
