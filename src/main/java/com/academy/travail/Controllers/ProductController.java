package com.academy.travail.Controllers;

import com.academy.travail.Dao.IOrder;
import com.academy.travail.Dao.IProduct;
import com.academy.travail.Models.Order;
import com.academy.travail.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public boolean deleteProduct(Long id)
    {
        try{
            Product o = iproduct.getById(id);
            iproduct.deleteById(id);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
