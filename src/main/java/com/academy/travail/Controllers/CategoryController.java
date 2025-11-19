package com.academy.travail.Controllers;

import com.academy.travail.Dao.ICategory;
import com.academy.travail.Models.Category;
import com.academy.travail.Models.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategory icategory;
    @PostMapping("/")
    public Category addCategory(@RequestBody Category category){
        return icategory.save(category);
    }
    @PutMapping ("/")
    public Category updateCategory(@RequestBody Category category){
        return icategory.saveAndFlush(category);
    }
    @GetMapping("/")
    public List<Category> getAllCategory()
    {
        return icategory.findAll();
    }
    @DeleteMapping("/")
    public HashMap<String,String> deleteCategory(Long id) {

        HashMap<String,String> reponse=new HashMap<String,String>();
        try {
        	Category c=icategory.getById(id);
            icategory.deleteById(id);
            reponse.put("state","true");
            return reponse;
        } catch (Exception e) {
            reponse.put("state","false");

            return reponse;
        }
    }





}
