package com.academy.travail.serializer;

import com.academy.travail.Models.SubCategory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;



    //pour une subcateg
public class SubCategSerialiser extends StdSerializer<SubCategory> {

        public SubCategSerialiser() {
            this(null);
        }

        public SubCategSerialiser(Class<SubCategory> t) {
            super(t);
        }

        @Override
        public void serialize(
                SubCategory item,
                JsonGenerator generator,
                SerializerProvider provider)
                throws IOException, JsonProcessingException {
            SubCategory SubCategory=new SubCategory();
            SubCategory.setTitle(item.getTitle());
            SubCategory.setId(item.getId());
            SubCategory.setDescription(item.getDescription());
            // category.setSubCategories(item.getSubCategories());
            generator.writeObject(SubCategory);
        }
    }

