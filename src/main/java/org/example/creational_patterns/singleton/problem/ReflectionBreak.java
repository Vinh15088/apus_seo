package org.example.creational_patterns.singleton.problem;

import org.example.creational_patterns.singleton.BillPugh;
import org.example.creational_patterns.singleton.Eager;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionBreak {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        // break eager with reflection
        Eager instance1 = Eager.getInstance();
        Eager instance2 = null;

        Constructor<?> [] constructors = Eager.class.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {
            constructor.setAccessible(true);
            instance2 = (Eager) constructor.newInstance();
        }

        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());


        // break bill pugh with reflection
        BillPugh instance3 = BillPugh.getInstance();
        BillPugh instance4 = null;

        Constructor<?> [] constructors3 = BillPugh.class.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors3) {
            constructor.setAccessible(true);

            instance4 = (BillPugh) constructor.newInstance();
        }

        System.out.println(instance3.hashCode());
        System.out.println(instance4.hashCode());
    }
}
