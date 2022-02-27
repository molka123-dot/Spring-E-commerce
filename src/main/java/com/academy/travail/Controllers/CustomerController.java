package com.academy.travail.Controllers;

import com.academy.travail.Dao.ICategory;
import com.academy.travail.Dao.ICustomer;
import com.academy.travail.Models.Category;
import com.academy.travail.Models.Customer;
import com.academy.travail.utils.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomer icustomer;
    @Autowired
    private StorageService storageService;
    @PostMapping("/")
    public Customer addCustomer(Customer customer , MultipartFile img){
       //upload to folder
        storageService.store(img,img.getOriginalFilename());
       //save to database
        customer.setPhoto(img.getOriginalFilename());
        return icustomer.save(customer);
    }
    @PutMapping("/")
    public Customer updateCustomer(@RequestBody Customer customer){
        return icustomer.saveAndFlush(customer);
    }
    @GetMapping("/")
    public List<Customer> getAllCustomer()
    {
        return icustomer.findAll();
    }
    @DeleteMapping("/")
    public boolean deleteCustomer(Long id)
    {
        try{
            Customer c = icustomer.getById(id);
            icustomer.deleteById(id);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
