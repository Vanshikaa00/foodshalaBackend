package com.assignment.foodshalaBackend.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users_login_details")
public class Users implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long uid;
    @Column(name="username")
    String username;
    @Column(name="password")
    String password;
    @Column(name="active")
    int active;
    @Column(name="role")
    String role;
    @Column(name="phno")
    Long phno;
    @Column(name="name")
    String name;
    @Column(name="foodtype")
    String foodtype;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getPhno() {
        return phno;
    }

    public void setPhno(Long phno) {
        this.phno = phno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoodtype() {
        return foodtype;
    }

    public void setFoodtype(String foodtype) {
        this.foodtype = foodtype;
    }


}
