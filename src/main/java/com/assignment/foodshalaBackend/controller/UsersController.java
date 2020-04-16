package com.assignment.foodshalaBackend.controller;
import com.assignment.foodshalaBackend.models.Users;
import com.assignment.foodshalaBackend.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/login")
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    //Get customers
    @GetMapping(path = "/getUser")
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    //Add customers
    @PostMapping(path = "/addUser")
    public Users createUser(@Valid @RequestBody Users users) {
        if(users.getFoodtype()==null)
        {
            users.setRole("restaurant");
        }
        else
        {
            users.setRole("customer");
        }
       users.setActive(1);
        return usersRepository.save(users);
    }
}
