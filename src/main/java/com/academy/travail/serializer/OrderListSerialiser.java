package com.academy.travail.serializer;

import com.academy.travail.Models.Order;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



    public class OrderListSerialiser extends StdSerializer<List<Order>> {

        public OrderListSerialiser() {
            this(null);
        }

        public OrderListSerialiser(Class<List<Order>> t) {
            super(t);
        }

        @Override
        public void serialize(
                List<Order> items,
                JsonGenerator generator,
                SerializerProvider provider)
                throws IOException, JsonProcessingException {

            List<Order> ids = new ArrayList<>();
            if(items!=null)
                for (Order item : items) {
                    Order sub=new Order();
                    sub.setId(item.getId());
                    sub.setRef(item.getRef());
                    sub.setPrice(item.getPrice());
                    sub.setDescrp(item.getDescrp());
                    sub.setQte(item.getQte());
                    ids.add(sub);
                }
            generator.writeObject(ids);
        }
    }





