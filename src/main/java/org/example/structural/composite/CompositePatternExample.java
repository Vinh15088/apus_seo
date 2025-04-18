package org.example.structural.composite;

public class CompositePatternExample {
    public static void main(String[] args) {
        File file1 = new File("Document.pdf");
        File file2 = new File("Image.png");
        File file3 = new File("Video.mp4");

        Folder folder1 = new Folder("Downloads");
        folder1.addComponent(file1);
        folder1.addComponent(file2);

        Folder folder2 = new Folder("Movies");
        folder2.addComponent(file3);

        Folder mainFolder = new Folder("Main Folder");
        mainFolder.addComponent(folder1);
        mainFolder.addComponent(folder2);

        mainFolder.showDetails();
    }
}
