package com.academy.travail.serializer;

import com.academy.travail.Models.Provider;
import com.academy.travail.Models.SubCategory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProviderListSerialiser extends StdSerializer<List<Provider>> {

        public ProviderListSerialiser() {
            this(null);
        }

        public ProviderListSerialiser(Class<List<Provider>> t) {
            super(t);
        }

        @Override
        public void serialize(
                List<Provider> items,
                JsonGenerator generator,
                SerializerProvider provider)
                throws IOException, JsonProcessingException {

            List<Provider> ids = new ArrayList<>();
            if(items!=null)
                for (Provider item : items) {
                    Provider sub=new Provider();
                    sub.setId(item.getId());
                    sub.setName(item.getName());
                    sub.setEmail(item.getEmail());
                    sub.setPassword(item.getPassword());
                    sub.setCompany(item.getCompany());
                    sub.setService(item.getService());

                    ids.add(sub);
                }
            generator.writeObject(ids);
        }
    }



