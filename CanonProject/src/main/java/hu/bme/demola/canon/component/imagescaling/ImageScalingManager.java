package hu.bme.demola.canon.component.imagescaling;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public interface ImageScalingManager {

    BufferedImage createThumbnail(String originalImagePath, int size) throws IOException;

    BufferedImage createThumbnail(File originalImageFile, int size) throws IOException;

    BufferedImage createThumbnail(BufferedImage original, int size);
}
