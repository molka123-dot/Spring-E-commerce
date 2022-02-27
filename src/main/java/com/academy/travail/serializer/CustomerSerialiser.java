package com.academy.travail.serializer;

import com.academy.travail.Models.Category;
import com.academy.travail.Models.Customer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
public class CustomerSerialiser extends StdSerializer<Customer> {

        public CustomerSerialiser() {
            this(null);
        }

        public CustomerSerialiser(Class<Customer> t) {
            super(t);
        }

        @Override
        public void serialize(
                Customer item,
                JsonGenerator generator,
                SerializerProvider provider)
                throws IOException, JsonProcessingException {
            Customer sub=new Customer();
            sub.setId(item.getId());
            sub.setName(item.getName());
            sub.setEmail(item.getEmail());
            sub.setPassword(item.getPassword());
            sub.setAdress(item.getAdress());
            sub.setCity(item.getCity());

            generator.writeObject(sub);
        }
    }

