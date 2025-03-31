package org.example.reflection.reflectionTest;

import org.example.reflection.Cat;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionAnnotation {
    public static void main(String[] args) throws ClassNotFoundException {

//        Class<?> classCat = Class.forName("org.example.reflection.Cat");
        Class<?> classCat = Cat.class;

        // get annotation with class
        Annotation[] annotations = classCat.getAnnotations();

        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        // get annotation with field
        Field[] fields = classCat.getDeclaredFields();

        for (Field field : fields) {
            Annotation[] fieldAnnotations = field.getAnnotations();
            for (Annotation fieldAnnotation : fieldAnnotations) {
                System.out.println(fieldAnnotation);
            }
        }

        // get annotation with method
        Method[] methods = classCat.getDeclaredMethods();

        for (Method method : methods) {
            Annotation[] methodAnnotations = method.getAnnotations();

            for (Annotation methodAnnotation : methodAnnotations) {
                System.out.println(methodAnnotation);
            }
        }
    }
}
