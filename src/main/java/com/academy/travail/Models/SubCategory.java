package com.academy.travail.Models;

import com.academy.travail.serializer.CustomSerializer;
import com.academy.travail.serializer.ProductListSerialiser;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="subcategories")
public class SubCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    @NotNull(message = "title cannot be null")
    private String title;
    @Column(name = "description")
    @NotNull(message = "description cannot be null")
    private String description;
    @ManyToOne
    @JsonSerialize(using = CustomSerializer.class)
    private Category categ;
    @OneToMany(mappedBy="subcateg")
    @JsonSerialize(using = ProductListSerialiser.class)
    private List<Product> products ;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Category getCateg() {
        return categ;
    }

    public void setCateg(Category categ) {
        this.categ = categ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
