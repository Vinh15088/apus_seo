package org.example.structural.adapter;

public class AdapterExample {
    public static void main(String[] args) {
        OldImageProcessor oldImageProcessor = new OldImageProcessor();
        ImageProcessor adapter = new ImageAdapter(oldImageProcessor);

        adapter.processImage("hehe.jpeg", "jpeg");
        adapter.processImage("hehe.jpg", "jpg");
    }
}
