package com.assignment.foodshalaBackend.service;

import com.assignment.foodshalaBackend.models.Users;
import com.assignment.foodshalaBackend.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
public class CurrentUserService {
    @Autowired
    private UsersRepository usersRepository;

    public Optional<Users> CurrentUser(Principal principal) {
        String username=principal.getName();
        return usersRepository.findByUsername(username);
    }

    public Long getUsersId (Principal principal) {
        String username = principal.getName();
        return usersRepository.findByUsername(username).get().getUid();
    }

    public Users getUserProfile(Principal principal) {
        Optional <Users> myp = usersRepository.findByUsername(principal.getName());
        return myp.get();
    }


}
