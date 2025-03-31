package org.example.reflection;

@MyAnnotation(name = "Cat", value = "class")
public class Cat extends Animal implements Sound{

    // public fields
    public static final String SOUND = "Meo meo";
    public static final int NUMBER_OF_LEGS = 4;

    // private fields
    @MyAnnotation(name = "Name", value = "field")
    private String name;
    @MyAnnotation(name = "Age", value = "field")
    private int age;

    // protected field
    private int quantity;

    @MyAnnotation(name = "Cat_Constructor", value = "constructor")
    public Cat() {

    }

    public Cat(String name) {
        this.name = name;
        this.age = 1;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public int getNumberOfLegs() {
        return NUMBER_OF_LEGS;
    }

    @Override
    public String sound() {
        return SOUND;
    }

    @MyAnnotation(name = "getName", value = "method")
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @MyAnnotation(name = "getAge", value = "method")
    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }
}
