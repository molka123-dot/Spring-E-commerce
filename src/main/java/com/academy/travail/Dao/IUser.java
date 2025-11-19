package com.academy.travail.Dao;

import com.academy.travail.Models.User;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUser extends JpaRepository<User,Long> {
	@org.springframework.data.jpa.repository.Query("select u from  User u where u.email= :email and u.password= :password")
	User login(@Param("email") String email,@Param("password") String password);

}
