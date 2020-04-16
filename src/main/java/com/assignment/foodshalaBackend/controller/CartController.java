package com.assignment.foodshalaBackend.controller;
import com.assignment.foodshalaBackend.models.OrderHistory;
import com.assignment.foodshalaBackend.service.CartService;
import com.assignment.foodshalaBackend.service.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CurrentUserService currentUserService;
    @Autowired
    private CartService cartService;

    public CartController(CartService cartService, CurrentUserService currentUserService) {
        this.cartService = cartService;
        this.currentUserService = currentUserService;
    }

    //show order history api
    @RequestMapping(value = "/showOrderHistory", method = RequestMethod.GET)
    @ResponseBody
    public List<OrderHistory> showorderhistory(Principal principal) {
        return cartService.showOrderHistory(currentUserService.getUsersId(principal), principal);
    }
}
