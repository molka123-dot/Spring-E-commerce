package com.academy.travail;

import com.academy.travail.utils.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TravailApplication implements CommandLineRunner {
    @Autowired
    private StorageService storageService;

    public static void main(String[] args) {
        SpringApplication.run(TravailApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
   //naamlhom marra wahda baad manruni nhothom fi cmtr
   // storageService.deleteAll();
  //  storageService.init();
    }
}
