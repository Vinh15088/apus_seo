package org.example.creational_patterns.prototype;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Laptop {
    private String cpu;
    private int ram;
    private int storage;

    public Laptop(String cpu, int ram, int storage) {
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                '}';
    }

    public Laptop clone() {
        try {
            return (Laptop) super.clone(); // shallow copy
        } catch (CloneNotSupportedException e) {
            return new Laptop(this.cpu, this.ram, this.storage);
        }
    }

    public static void main(String[] args) {
        Laptop laptop = new Laptop("Intel", 8, 512);
        Laptop laptop1 = laptop.clone();

        laptop1.ram = 16;


        System.out.println(laptop);
        System.out.println(laptop1);
    }

}
