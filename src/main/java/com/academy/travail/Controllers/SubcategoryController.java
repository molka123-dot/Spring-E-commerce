package com.academy.travail.Controllers;

import com.academy.travail.Dao.IProvider;
import com.academy.travail.Dao.ISubcategory;
import com.academy.travail.Models.Provider;
import com.academy.travail.Models.SubCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subcategories")
public class SubcategoryController {
    @Autowired
    private ISubcategory isubcategory;
    @PostMapping("/")
    public SubCategory addSubcategory(@RequestBody SubCategory subcategory){
        return isubcategory.save(subcategory);
    }
    @PutMapping("/")
    public SubCategory updateSubCategory(@RequestBody SubCategory subcategory){
        return isubcategory.saveAndFlush(subcategory);
    }
    @GetMapping("/")
    public List<SubCategory> getAlLSubCategory()
    {
        return isubcategory.findAll();
    }
    @DeleteMapping("/")
    public boolean deleteSubCategory(Long id)
    {
        try{
            SubCategory sc = isubcategory.getById(id);
            isubcategory.deleteById(id);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
