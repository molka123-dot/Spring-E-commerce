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
@Table(name="orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ref")
    @NotNull(message = "ref cannot be null")
    private String ref;
    @Column(name = "price")
    @NotNull(message = "price cannot be null")
    private double price;
    @Column(name = "descrp")
    @NotNull(message = "descrp cannot be null")
    private String descrp;
    @Column(name = "qte")
    @NotNull(message = "qte cannot be null")
    private double qte;
    @ManyToOne
    @JsonSerialize(using = CustomSerializer.class)
    private Customer customer;
    @ManyToMany
    @JoinTable(name = "itemProduct", joinColumns =@JoinColumn(name = "product_id") , inverseJoinColumns = @JoinColumn(name = "order_id"))
    @JsonSerialize(using = ProductListSerialiser.class)
    private List<Product> products ;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescrp() {
        return descrp;
    }

    public void setDescrp(String descrp) {
        this.descrp = descrp;
    }

    public double getQte() {
        return qte;
    }

    public void setQte(double qte) {
        this.qte = qte;
    }
}