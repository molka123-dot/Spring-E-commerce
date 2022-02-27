package com.academy.travail.Controllers;

import com.academy.travail.Dao.ICategory;
import com.academy.travail.Models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public boolean deleteCategory(Long id)
    {
        try{
            Category c = icategory.getById(id);
            icategory.deleteById(id);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }





}
