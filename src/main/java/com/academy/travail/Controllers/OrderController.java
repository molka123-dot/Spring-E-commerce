package com.academy.travail.Controllers;

import com.academy.travail.Dao.IOrder;
import com.academy.travail.Models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
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
    public HashMap<String,String> deleteOrder(Long id) {

        HashMap<String,String> reponse=new HashMap<String,String>();
        try {
        	Order c=iorder.getById(id);
        	iorder.deleteById(id);
            reponse.put("state","true");
            return reponse;
        } catch (Exception e){
            reponse.put("state","false");

            return reponse;
        }
    }
}
