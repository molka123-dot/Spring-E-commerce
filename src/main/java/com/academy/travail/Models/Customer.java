package com.academy.travail.Models;
import com.academy.travail.serializer.CustomSerializer;
import com.academy.travail.serializer.OrderListSerialiser;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="customers")
public class Customer extends User implements Serializable {
    @Column(name = "adress")
    @NotNull(message = "adress cannot be null")
    private String adress;
    @Column(name = "city")
    @NotNull(message = "city cannot be null")
    private String city;
    @OneToMany(mappedBy="customer")
    @JsonSerialize(using = OrderListSerialiser.class)
    private List<Order> orders ;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
