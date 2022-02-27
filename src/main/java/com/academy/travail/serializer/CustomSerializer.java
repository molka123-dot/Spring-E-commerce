package com.academy.travail.serializer;

import com.academy.travail.Models.Category;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
//pour category
public class CustomSerializer extends StdSerializer<Category> {

    public CustomSerializer() {
        this(null);
    }

    public CustomSerializer(Class<Category> t) {
        super(t);
    }

    @Override
    public void serialize(
            Category item,
            JsonGenerator generator,
            SerializerProvider provider)
            throws IOException, JsonProcessingException {
        Category category=new Category();
        category.setTitle(item.getTitle());
        category.setId(item.getId());
        category.setDescription(item.getDescription());
        // category.setSubCategories(item.getSubCategories());
        generator.writeObject(category);
    }
}