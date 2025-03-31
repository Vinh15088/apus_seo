package org.example.creational_patterns.singleton.problem;

import org.example.creational_patterns.singleton.Enum;

import java.io.*;

public class SerializedTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Serialized serialized1 = Serialized.getInstance();
        Enum num1 = Enum.INSTANCE;

        ObjectOutput output = new ObjectOutputStream(new FileOutputStream("serializedTest.txt"));
        output.writeObject(serialized1);
        output.writeObject(num1);
        output.close();

        ObjectInput input = new ObjectInputStream(new FileInputStream("serializedTest.txt"));
        Serialized serialized2 = (Serialized) input.readObject();
        Enum num2 = (Enum) input.readObject();

        System.out.println(serialized1.hashCode());
        System.out.println(serialized2.hashCode());
        System.out.println(num1.hashCode());
        System.out.println(num2.hashCode());

    }
}
