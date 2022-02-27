package com.academy.travail.serializer;

import com.academy.travail.Models.Category;
import com.academy.travail.Models.Provider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;




    public class ProviderSerialiser extends StdSerializer<Provider> {

        public ProviderSerialiser() {
            this(null);
        }

        public ProviderSerialiser(Class<Provider> t) {
            super(t);
        }

        @Override
        public void serialize(
                Provider item,
                JsonGenerator generator,
                SerializerProvider provider)
                throws IOException, JsonProcessingException {
            Provider sub=new Provider();
            sub.setId(item.getId());
            sub.setName(item.getName());
            sub.setEmail(item.getEmail());
            sub.setPassword(item.getPassword());
            sub.setCompany(item.getCompany());
            sub.setService(item.getService());

            // category.setSubCategories(item.getSubCategories());
            generator.writeObject(sub);
        }
    }
