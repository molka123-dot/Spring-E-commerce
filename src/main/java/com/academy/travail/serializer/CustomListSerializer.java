package com.academy.travail.serializer;
import com.academy.travail.Models.SubCategory;
//import com.academy.travail.models.SubCategory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//pour liste de subcategory
public class CustomListSerializer extends StdSerializer<List<SubCategory>> {

        public CustomListSerializer() {
            this(null);
        }

        public CustomListSerializer(Class<List<SubCategory>> t) {
            super(t);
        }

        @Override
        public void serialize(
                List<SubCategory> items,
                JsonGenerator generator,
                SerializerProvider provider)
                throws IOException, JsonProcessingException {

            List<SubCategory> ids = new ArrayList<>();
            if(items!=null)
                for (SubCategory item : items) {
                    SubCategory sub=new SubCategory();
                    sub.setTitle(item.getTitle());
                    ids.add(sub);
                }
            generator.writeObject(ids);
        }
    }

