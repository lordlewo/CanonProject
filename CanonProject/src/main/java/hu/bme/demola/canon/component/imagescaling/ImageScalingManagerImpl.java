package hu.bme.demola.canon.component.imagescaling;

import org.imgscalr.Scalr;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Component
@Scope("singleton")
public class ImageScalingManagerImpl implements ImageScalingManager{

    public BufferedImage createThumbnail(String originalImagePath, int size) throws IOException {

        BufferedImage image = ImageIO.read(new File(originalImagePath));

        BufferedImage thumb = Scalr.resize(image, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_TO_HEIGHT, size);

        return thumb;
    }

    public BufferedImage createThumbnail(File originalImageFile, int size) throws IOException {

        BufferedImage image = ImageIO.read(originalImageFile);

        BufferedImage thumb = Scalr.resize(image, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_TO_HEIGHT, size);

        return thumb;
    }

    public BufferedImage createThumbnail(BufferedImage originalImage, int size) {

        BufferedImage thumb = Scalr.resize(originalImage, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_TO_HEIGHT, size);

        return thumb;
    }
}
