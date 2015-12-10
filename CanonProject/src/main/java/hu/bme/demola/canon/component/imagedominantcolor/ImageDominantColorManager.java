package hu.bme.demola.canon.component.imagedominantcolor;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public interface ImageDominantColorManager {

    String getDominantColorInRGBString(String imagePath) throws IOException;

    String getDominantColorInRGBString(File imageFile) throws IOException;

    String getDominantColorInRGBString(BufferedImage image);

    String getDominantColorInRGBHexString(String imagePath) throws IOException;

    String getDominantColorInRGBHexString(File imageFile) throws IOException;

    String getDominantColorInRGBHexString(BufferedImage image);
}
