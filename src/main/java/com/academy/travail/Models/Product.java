package com.academy.travail.Models;

import com.academy.travail.serializer.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    @NotNull(message = "name cannot be null")
    private String name;
    @Column(name = "price")
    @NotNull(message = "price cannot be null")
    private int  price;
    @Column(name = "description")
    @NotNull(message = "description cannot be null")
    private String description;
    @ManyToOne
    @JsonSerialize(using = SubCategSerialiser.class)
    private SubCategory subcateg;
    @ManyToOne
    @JsonSerialize(using = ProviderSerialiser.class)
    private Provider provider;
    @ManyToMany(mappedBy="products")
    @JsonSerialize(using = OrderListSerialiser.class)
    private List<Order> orders ;

    public SubCategory getSubcateg() {
        return subcateg;
    }

    public void setSubcateg(SubCategory subcateg) {
        this.subcateg = subcateg;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
