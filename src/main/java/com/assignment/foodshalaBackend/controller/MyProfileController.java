package com.assignment.foodshalaBackend.controller;

import com.assignment.foodshalaBackend.models.Users;
import com.assignment.foodshalaBackend.repo.UsersRepository;
import com.assignment.foodshalaBackend.service.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/profile")
public class MyProfileController {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    CurrentUserService currentUserService;

//get user profile
    @RequestMapping(value = "/getUserData", method = RequestMethod.GET)
    @ResponseBody
    public Users getUserData(Principal principal) {
        return currentUserService.getUserProfile(principal);
    }
    
//update user profile
    @RequestMapping(value = "/updateUserData", method = RequestMethod.PUT)
    @ResponseBody
    public Users updateUserData(@Valid @RequestBody Users users) {
        users.setActive(1);
        usersRepository.save(users);
        return users;
    }

}
