package hu.bme.demola.canon.component.imagedominantcolor;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import hu.bme.demola.canon.component.imagedominantcolor.colorthief.ColorThief;
import hu.bme.demola.canon.component.imagedominantcolor.colorthief.MMCQ.VBox;
import hu.bme.demola.canon.component.imagedominantcolor.colorthief.MMCQ.CMap;

import javax.imageio.ImageIO;

@Component
@Scope("singleton")
public class ImageDominantColorManagerImpl implements ImageDominantColorManager {

    /**
     * Creates a string representation of an RGB array.
     *
     * @param rgb
     *            the RGB array
     *
     * @return the string representation
     */
    public static String createRGBString(int[] rgb)
    {
        return "rgb(" + rgb[0] + "," + rgb[1] + "," + rgb[2] + ")";
    }

    /**
     * Creates an HTML hex color code for the given RGB array (e.g.
     * <code>#ff0000</code> for red).
     *
     * @param rgb
     *            the RGB array
     *
     * @return the HTML hex color code
     */
    public static String createRGBHexString(int[] rgb)
    {
        String rgbHex = Integer.toHexString(rgb[0] << 16 | rgb[1] << 8 | rgb[2]);

        // Left-pad with 0s
        int length = rgbHex.length();
        if (length < 6)
        {
            rgbHex = "00000".substring(0, 6 - length) + rgbHex;
        }

        return "#" + rgbHex;
    }

    public String getDominantColorInRGBString(String imagePath) throws IOException {

        BufferedImage image = ImageIO.read(new File(imagePath));

        // The dominant color is taken from a 5-map
        CMap result = ColorThief.getColorMap(image, 5);
        VBox dominantColor = result.vboxes.get(0);

        int[] rgb = dominantColor.avg(false);

        // Create color String representation
        String rgbString = createRGBString(rgb);

        return rgbString;
    }

    public String getDominantColorInRGBString(File imageFile) throws IOException {

        BufferedImage image = ImageIO.read(imageFile);

        // The dominant color is taken from a 5-map
        CMap result = ColorThief.getColorMap(image, 5);
        VBox dominantColor = result.vboxes.get(0);

        int[] rgb = dominantColor.avg(false);

        // Create color String representation
        String rgbString = createRGBString(rgb);

        return rgbString;
    }

    public String getDominantColorInRGBString(BufferedImage image) {

        // The dominant color is taken from a 5-map
        CMap result = ColorThief.getColorMap(image, 5);
        VBox dominantColor = result.vboxes.get(0);

        int[] rgb = dominantColor.avg(false);

        // Create color String representation
        String rgbString = createRGBString(rgb);

        return rgbString;
    }

    public String getDominantColorInRGBHexString(String imagePath) throws IOException {

        BufferedImage image = ImageIO.read(new File(imagePath));

        // The dominant color is taken from a 5-map
        CMap result = ColorThief.getColorMap(image, 5);
        VBox dominantColor = result.vboxes.get(0);

        int[] rgb = dominantColor.avg(false);

        // Create color String representation
        String rgbHexString = createRGBHexString(rgb);

        return rgbHexString;
    }

    public String getDominantColorInRGBHexString(File imageFile) throws IOException {

        BufferedImage image = ImageIO.read(imageFile);

        // The dominant color is taken from a 5-map
        CMap result = ColorThief.getColorMap(image, 5);
        VBox dominantColor = result.vboxes.get(0);

        int[] rgb = dominantColor.avg(false);

        // Create color String representation
        String rgbHexString = createRGBHexString(rgb);

        return rgbHexString;
    }

    public String getDominantColorInRGBHexString(BufferedImage image) {

        // The dominant color is taken from a 5-map
        CMap result = ColorThief.getColorMap(image, 5);
        VBox dominantColor = result.vboxes.get(0);

        int[] rgb = dominantColor.avg(false);

        // Create color String representation
        String rgbHexString = createRGBHexString(rgb);

        return rgbHexString;
    }
}
