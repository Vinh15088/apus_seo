package org.example.creational_patterns.prototype;

public class TypesOfCopies {

    static class HardDrive {
        private String type;

        public HardDrive(String type) {
            this.type = type;
        }

        public HardDrive clone() {
            return new HardDrive(this.type);
        }
    }

    static class Laptop implements Cloneable {
        private final String cpu;
        private final HardDrive hardDrive;

        public Laptop(String cpu, HardDrive hardDrive) {
            this.cpu = cpu;
            this.hardDrive = hardDrive;
        }

        public Object cloneShallow() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e) {
                return e;
            }
        }

        public Laptop cloneDeep() {
            return new Laptop(this.cpu, this.hardDrive.clone());
        }

        @Override
        public String toString() {
            return "Laptop{" +
                    "cpu='" + cpu + '\'' +
                    ", hardDrive=" + hardDrive.type +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println("Shallow Copy"); // copy reference
        HardDrive hdd = new HardDrive("SSD 512GB");
        Laptop laptop = new Laptop("Intel i7", hdd);
        Laptop cloneShallow = (Laptop) laptop.cloneShallow();

        cloneShallow.hardDrive.type = "HDD 1TB";
        System.out.println(laptop);
        System.out.println(cloneShallow);

        System.out.println("Deep Copy"); // copy object
        Laptop laptop1 = new Laptop("Intel i9", hdd);
        Laptop cloneDeep = laptop1.cloneDeep();
        cloneDeep.hardDrive.type = "HDD 2TB";
        System.out.println(laptop1);
        System.out.println(cloneDeep);

    }
}
