package com.assignment.foodshalaBackend.controller;

import com.assignment.foodshalaBackend.models.Food;
import com.assignment.foodshalaBackend.models.Users;
import com.assignment.foodshalaBackend.repo.FoodRepository;
import com.assignment.foodshalaBackend.repo.UsersRepository;
import com.assignment.foodshalaBackend.service.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/home")
public class FoodController {

    @Autowired
    FoodRepository foodRepository;
    @Autowired
    CurrentUserService currentUserService;
    @Autowired
    UsersRepository usersRepository;

    //Get food
    @GetMapping(path = "/getFood")
    public List<Food> getAllFood(){
        return foodRepository.findAll();
    }

    //Add food to menu
    @PostMapping("/addFood")
    public Food addFood(@Valid @RequestBody Food food,Principal principal) {
        Long userid=currentUserService.getUsersId(principal);
        Users users=usersRepository.findByUid(userid);
        food.setUsers(users);
        food.setActive(1);
        return foodRepository.save(food);
    }


    //Get food by type (Veg/Non-Veg)
    @GetMapping("/getFoodByType/{foodtype}")
    public List<Food> getFoodByType(@PathVariable(value = "foodtype")String foodtype) {
        return  foodRepository.findAllByFoodtype(foodtype);
    }

}
