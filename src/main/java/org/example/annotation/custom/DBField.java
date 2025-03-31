package org.example.annotation.custom;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface DBField {
    String name();

    Class<?> type();

    boolean isPrimaryKey() default false;
}
