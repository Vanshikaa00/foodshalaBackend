package com.assignment.foodshalaBackend.repo;

import com.assignment.foodshalaBackend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByUid(Long id);
    Optional<Users> findByUsername(String uname);
    @Override
    List<Users> findAll();
}
