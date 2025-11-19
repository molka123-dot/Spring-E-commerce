package com.academy.travail.Controllers;

import com.academy.travail.Dao.IProduct;
import com.academy.travail.Dao.IProvider;
import com.academy.travail.Models.Product;
import com.academy.travail.Models.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/providers")
public class ProviderController {
    @Autowired
    private IProvider iprovider;
    @PostMapping("/")
    public Provider addProvider(@RequestBody Provider provider){
        return iprovider.save(provider);
    }
    @PutMapping("/")
    public Provider updateProvider(@RequestBody Provider provider){
        return iprovider.saveAndFlush(provider);
    }
    @GetMapping("/")
    public List<Provider> getAlLProvider()
    {
        return iprovider.findAll();
    }
    @DeleteMapping("/")
    public HashMap<String,String> deleteProvider(Long id) {

        HashMap<String,String> reponse=new HashMap<String,String>();
        try {
        	Provider c=iprovider.getById(id);
            iprovider.deleteById(id);
            reponse.put("state","true");
            return reponse;
        } catch (Exception e) {
            reponse.put("state","false");

            return reponse;
        }
    }
}
