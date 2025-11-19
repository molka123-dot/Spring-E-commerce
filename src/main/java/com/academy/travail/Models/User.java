package com.academy.travail.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Entity
@Table(name="users")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)//3eme heritage JPA
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Column(name = "name")
    ///@NotNull(message = "name cannot be null")
    private String name;
    @Column(name = "email")
    @NotNull(message = "email cannot be null")
    private String email;
    @Column(name = "password")
    @NotNull(message = "password cannot be null")
    private String password;
    @Column(name = "photo")
   /// @NotNull(message = "photo cannot be null")
    private String photo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}

