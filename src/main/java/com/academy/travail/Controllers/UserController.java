package com.academy.travail.Controllers;


import com.academy.travail.Dao.IUser;
import com.academy.travail.Models.User;
import com.academy.travail.utils.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUser iuser;


    @PostMapping("/")
    public User addUser(@RequestBody User user){

        return iuser.save(user);
    }
    @PutMapping("/")
    public User updateUser(@RequestBody User user){
        return iuser.saveAndFlush(user);
    }
    @GetMapping("/")
    public List<User> getAlLUser()
    {
        return iuser.findAll();
    }
    @DeleteMapping("/")
    public boolean deleteUser(Long id)
    {
        try{
            User u = iuser.getById(id);
            iuser.deleteById(id);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

}
