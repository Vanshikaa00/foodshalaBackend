package com.assignment.foodshalaBackend.models;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="food_info")
public class Food implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long fid;
        @Column(name="foodname")
        String foodname;
        @Column(name="foodprice")
        Long foodprice;
        @Column(name="foodtype")
        String foodtype;
        @Column(name="foodimgsrc")
        String foodimgsrc;
        @Column(name="fooddes")
        String fooddes;
        @Column(name = "active")
        int active;
        @ManyToOne
        Users users;

    public Long getFid() {
        return fid;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public Long getFoodprice() {
        return foodprice;
    }

    public void setFoodprice(Long foodprice) {
        this.foodprice = foodprice;
    }

    public String getFoodtype() {
        return foodtype;
    }

    public void setFoodtype(String foodtype) {
        this.foodtype = foodtype;
    }

    public String getFoodimgsrc() {
        return foodimgsrc;
    }

    public void setFoodimgsrc(String foodimgsrc) {
        this.foodimgsrc = foodimgsrc;
    }

    public String getFooddes() {
        return fooddes;
    }

    public void setFooddes(String fooddes) {
        this.fooddes = fooddes;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
