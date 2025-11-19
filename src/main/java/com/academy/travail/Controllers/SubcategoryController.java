package com.academy.travail.Controllers;

import com.academy.travail.Dao.IProvider;
import com.academy.travail.Dao.ISubcategory;
import com.academy.travail.Models.Product;
import com.academy.travail.Models.Provider;
import com.academy.travail.Models.SubCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
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
    public HashMap<String,String> deleteSubCategory(Long id) {

        HashMap<String,String> reponse=new HashMap<String,String>();
        try {
        	SubCategory c=isubcategory.getById(id);
            isubcategory.deleteById(id);
            reponse.put("state","true");
            return reponse;
        } catch (Exception e) {
            reponse.put("state","false");

            return reponse;
        }
    }
}
