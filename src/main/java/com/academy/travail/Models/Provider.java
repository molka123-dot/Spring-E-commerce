package com.academy.travail.Models;
import com.academy.travail.serializer.ProductListSerialiser;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="providers")
public class Provider extends User implements Serializable {
    @Column(name = "service")
    @NotNull(message = "service cannot be null")
    private String service;
    @Column(name = "company")
    @NotNull(message = "company cannot be null")
    private String company;
    @OneToMany(mappedBy="provider")
    @JsonSerialize(using = ProductListSerialiser.class)
    private List<Product> products ;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
