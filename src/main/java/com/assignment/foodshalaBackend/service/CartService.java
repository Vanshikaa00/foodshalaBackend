package com.assignment.foodshalaBackend.service;

import com.assignment.foodshalaBackend.models.Cart;
import com.assignment.foodshalaBackend.models.Food;
import com.assignment.foodshalaBackend.models.OrderHistory;
import com.assignment.foodshalaBackend.models.Users;
import com.assignment.foodshalaBackend.repo.CartRepository;
import com.assignment.foodshalaBackend.repo.FoodRepository;
import com.assignment.foodshalaBackend.repo.OrderHistoryRepository;
import com.assignment.foodshalaBackend.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class CartService {
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private OrderHistoryRepository orderHistoryRepository;

    /******************************show order history********************************/
    public List <OrderHistory> showOrderHistory(Long userid, Principal principal) {
        Users users= usersRepository.findByUid(userid);
        return orderHistoryRepository.findAllByUsers(users);
    }

//*****************************add food to cart********************************************************

    public Cart addfood(Long fid, Long customerid) {
       Users users= usersRepository.findByUid(customerid);
        Food food = foodRepository.findByFid(fid);
        if (cartRepository.findByUsersAndFood(users,food).isPresent()) {
            Cart cart = cartRepository.findByUsersAndFood(users,food).get();
            cart.setQuantity(cart.getQuantity() + 1);
            cart.setAmount(cart.getQuantity()*food.getFoodprice());
            cartRepository.save(cart);
        } else {
            Cart c = new Cart(users,food,1);
            cartRepository.save(c);
        }
        return cartRepository.findByUsersAndFood(users,food).get();
    }


    /*****************************remove product from cart********************************************************/
    public String removefood(Long fid,Long cid) {
        Users customers = usersRepository.findByUid(cid);
       Food food = foodRepository.findByFid(fid);
        Cart cart = cartRepository.findByUsersAndFood(customers,food).get();
        cartRepository.delete(cart);
        return "\"product removed from cart!\"";
    }


    /**********************************show cart**************************************************/
    public List<Cart> showcart(Long user_id) {
       Users user = usersRepository.findByUid(user_id);
        return cartRepository.findByUsersAndFood_Active(user,1);
    }

    /********************************clear cart*******************************************/
    public String clearCart(Long user_id, Principal principal) {
        Users user = usersRepository.findByUid(user_id);
        List<Cart> cartItems=cartRepository.findAllByUsers(user);
        for (Cart cart : cartItems) {
            cartRepository.deleteById(cart.getCartid());
        }
        return "cart cleared!";
    }


}
