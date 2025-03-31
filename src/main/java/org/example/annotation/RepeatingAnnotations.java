package org.example.annotation;

import java.lang.annotation.*;

public class RepeatingAnnotations {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Filters.class)
    public @interface Filter {
        String value() default "filter";
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Filters {
        Filter[] value();
    }

    // use repeating annotations
//    @Filters({@Filter("filter1"), @Filter("filter2")})
    @Filter("filter1")
    @Filter("filter2")
    public interface Filterable {

    }

    public static void main(String[] args) {
        Filters filters = Filterable.class.getAnnotation(Filters.class);

        for (Filter filter : filters.value()) {
            System.out.println(filter.value());
        }
    }
}
