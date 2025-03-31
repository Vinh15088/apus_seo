package org.example.annotation.custom;

import org.example.annotation.User;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InfoAnnotation {

    @SafeVarargs
    private static void print(List<String>... names) {
        for (List<?> name : names) {
            System.out.println(name);
        }
    }

//    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws IllegalAccessException {
        System.out.println("Custom Annotation");
        System.out.println();

        User user = new User();
        user.setId(1);
        user.setName("vinhSeo");
        user.setEmail("vinhSeo@gmail.com");
        user.setDateOfBirth(new Date());

        List<String> list = new ArrayList<>();
        list.add("value1");
        list.add("value2");
        print(list);

        for (Field field : user.getClass().getDeclaredFields()) {
            // get annotation in field
            DBField dbField = field.getAnnotation(DBField.class);
            System.out.println("Field: " + field.getName());

            field.setAccessible(true);
            Object value = field.get(user);

            // get field value
            System.out.println("Value: " + value);

            // get field type
            System.out.println("Type: " + dbField.type());

            // check is primary key
            System.out.println("Is primary: " + dbField.isPrimaryKey());

            System.out.println("===================");
        }
    }
}
