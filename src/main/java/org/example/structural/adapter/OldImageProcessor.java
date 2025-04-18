package org.example.structural.adapter;

// adaptee
public class OldImageProcessor {
    void processPng(String fileName) {
        System.out.println("Processing png image: " + fileName);
    }
}
