package com.academy.travail.Controllers;

import com.academy.travail.Dao.IOrder;
import com.academy.travail.Dao.IProduct;
import com.academy.travail.Models.Order;
import com.academy.travail.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProduct iproduct;
    @PostMapping("/")
    public Product addProduct(@RequestBody Product product){
        return iproduct.save(product);
    }
    @PutMapping("/")
    public Product updateProduct(@RequestBody Product product){
        return iproduct.saveAndFlush(product);
    }
    @GetMapping("/")
    public List<Product> getAlLProduct()
    {
        return iproduct.findAll();
    }
    @DeleteMapping("/")
    public HashMap<String,String> deleteProduct(Long id) {

        HashMap<String,String> reponse=new HashMap<String,String>();
        try {
            Product c=iproduct.getById(id);
            iproduct.deleteById(id);
            reponse.put("state","true");
            return reponse;
        } catch (Exception e) {
            reponse.put("state","false");

            return reponse;
        }
    }
}
