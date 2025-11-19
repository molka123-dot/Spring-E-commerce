package com.academy.travail.Controllers;


import com.academy.travail.Dao.IUser;
import com.academy.travail.Models.User;
import com.academy.travail.utils.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private IUser iuser;

    
  
    @PostMapping("/")
    public User login(@RequestBody User u) {
    	try {
    		User c = iuser.login(u.getEmail(), u.getPassword());
    		return c;

    	}
    	catch(Exception e) {
    		return null;
    	}
    	}
    

}
