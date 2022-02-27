package com.academy.travail.Controllers;

import com.academy.travail.Dao.IOrder;
import com.academy.travail.Models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IOrder iorder;
    @PostMapping("/")
    public Order addOrder(@RequestBody Order order){
        return iorder.save(order);
    }
    @PutMapping("/")
    public Order updateOrder(@RequestBody Order order){
        return iorder.saveAndFlush(order);
    }
    @GetMapping("/")
    public List<Order> getAllOrder()
    {
        return iorder.findAll();
    }
    @DeleteMapping("/")
    public boolean deleteOrder(Long id)
    {
        try{
            Order o = iorder.getById(id);
            iorder.deleteById(id);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
