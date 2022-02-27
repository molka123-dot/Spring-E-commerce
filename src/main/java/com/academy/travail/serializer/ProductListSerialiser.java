package com.academy.travail.serializer;
import com.academy.travail.Models.Product;
import com.academy.travail.Models.SubCategory;
//import com.academy.travail.models.SubCategory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class ProductListSerialiser extends StdSerializer<List<Product>> {

    public ProductListSerialiser() {
        this(null);
    }

    public ProductListSerialiser(Class<List<Product>> t) {
        super(t);
    }

    @Override
    public void serialize(
            List<Product> items,
            JsonGenerator generator,
            SerializerProvider provider)
            throws IOException, JsonProcessingException {

        List<Product> ids = new ArrayList<>();
        if(items!=null)
            for (Product item : items) {
                Product sub=new Product();
                sub.setId(item.getId());
                sub.setName(item.getName());
                sub.setDescription(item.getDescription());
                sub.setPrice(item.getPrice());
                ids.add(sub);
            }
        generator.writeObject(ids);
    }
}

