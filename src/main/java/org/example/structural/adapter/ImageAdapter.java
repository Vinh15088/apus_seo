package org.example.structural.adapter;

public class ImageAdapter implements ImageProcessor{

    private OldImageProcessor oldImageProcessor;

    public ImageAdapter(OldImageProcessor oldImageProcessor) {
        this.oldImageProcessor = oldImageProcessor;
    }

    @Override
    public void processImage(String fileName, String format) {
        if(format.equalsIgnoreCase("JPEG")) {
            System.out.println("Converting JPEG to PNG");
            fileName = fileName.replace(".jpg", ".png");
        }
        oldImageProcessor.processPng(fileName);
    }
}
