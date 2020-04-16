package com.assignment.foodshalaBackend.models;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cart_info")
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartid")
    Long cartid;
    @ManyToOne
    private Users users;
    @ManyToOne
    private Food food;
    @Column(name = "quantity")
    int quantity;
    @Column(name = "amount")
    double amount;

    public Cart(com.assignment.foodshalaBackend.models.Users users, Food food, int quantity) {
        this.users=users;
        this.food=food;
        this.quantity = quantity;
    }
    public Cart()
    { }

    public Long getCartid() {
        return cartid;
    }

    public void setCartid(Long cartid) {
        this.cartid = cartid;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
