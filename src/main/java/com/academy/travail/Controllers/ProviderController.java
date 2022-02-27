package com.academy.travail.Controllers;

import com.academy.travail.Dao.IProduct;
import com.academy.travail.Dao.IProvider;
import com.academy.travail.Models.Product;
import com.academy.travail.Models.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public boolean deleteProvider(Long id)
    {
        try{
            Provider p = iprovider.getById(id);
            iprovider.deleteById(id);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
