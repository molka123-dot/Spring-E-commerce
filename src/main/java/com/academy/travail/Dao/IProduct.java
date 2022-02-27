package com.academy.travail.Dao;

import com.academy.travail.Models.Product;
import com.academy.travail.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProduct extends JpaRepository<Product,Long> {
}
