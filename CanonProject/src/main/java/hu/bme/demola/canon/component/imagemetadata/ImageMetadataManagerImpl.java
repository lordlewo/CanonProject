package hu.bme.demola.canon.component.imagemetadata;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.lang.GeoLocation;
import com.drew.lang.Rational;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifDirectoryBase;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.exif.GpsDirectory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Component
@Scope("singleton")
public class ImageMetadataManagerImpl implements ImageMetadataManager {

    public static final String KEY_IMAGE_HEIGHT = "key.image.height";
    public static final String KEY_IMAGE_WIDTH = "key.image.width";
    public static final String KEY_IMAGE_FLASH = "key.image.flash";
    public static final String KEY_IMAGE_DATE = "key.image.date";

    public static final String KEY_IMAGE_MAKE = "key.image.make";
    public static final String KEY_IMAGE_MODEL = "key.image.model";
    public static final String KEY_IMAGE_X_RESOLUTION = "key.image.x.resolution";
    public static final String KEY_IMAGE_Y_RESOLUTION = "key.image.y.resolution";
    public static final String KEY_IMAGE_ORIENTATION = "key.image.orientation";

    public static final String orientationMap[] = new String[]{
            "Top, left side (Horizontal / normal)",
            "Top, right side (Mirror horizontal)",
            "Bottom, right side (Rotate 180)",
            "Bottom, left side (Mirror vertical)",
            "Left side, top (Mirror horizontal and rotate 270 CW)",
            "Right side, top (Rotate 90 CW)",
            "Right side, bottom (Mirror horizontal and rotate 90 CW)",
            "Left side, bottom (Rotate 270 CW)"
    };


    // get metadata

    private Metadata getMetadata(String imagePath) throws ImageProcessingException, IOException {

        File imageFile = new File(imagePath);

        return getMetadata(imageFile);
    }

    private Metadata getMetadata(File imageFile) throws ImageProcessingException, IOException {

        return ImageMetadataReader.readMetadata(imageFile);
    }

    // geolocation datas

    public GeoLocation getGeoLocation(String imagePath){

        File imageFile = new File(imagePath);

        return getGeoLocation(imageFile);
    }

    public GeoLocation getGeoLocation(File imageFile){

        List<GeoLocation> geoLocations = getGeoLocations(imageFile);

        if(geoLocations.isEmpty()){
            return null;
        } else {
            return geoLocations.get(0);
        }
    }

    private GeoLocation getGeoLocation(Metadata metadata){

        List<GeoLocation> geoLocations = getGeoLocations(metadata);

        if(geoLocations.isEmpty()){
            return null;
        } else {
            return geoLocations.get(0);
        }
    }

    public List<GeoLocation> getGeoLocations(String imagePath){

        File imageFile = new File(imagePath);

        return getGeoLocations(imageFile);
    }

    public List<GeoLocation> getGeoLocations(File imageFile){

        List<GeoLocation> geoLocations = new ArrayList<GeoLocation>();

        try {
            geoLocations = getGeoLocations(getMetadata(imageFile));
        } catch (ImageProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return geoLocations;
    }

    private List<GeoLocation> getGeoLocations(Metadata metadata) {

        List<GeoLocation> geoLocations = new ArrayList<GeoLocation>();

        Collection<GpsDirectory> gpsDirectories = metadata.getDirectoriesOfType(GpsDirectory.class);

        if(gpsDirectories != null){
            for (GpsDirectory gpsDirectory: gpsDirectories) {
                GeoLocation geoLocation = gpsDirectory.getGeoLocation();

                if(geoLocation != null && !geoLocation.isZero()){
                    geoLocations.add(geoLocation);
                }
            }
        }

        return geoLocations;
    }

    // other metadatas - only relevant

    public Map<String, Object> getExifIFD0Datas(String imagePath){

        File imageFile = new File(imagePath);

        return getExifIFD0Datas(imageFile);
    }

    public Map<String, Object> getExifIFD0Datas(File imageFile){

        Map<String, Object> exifIFD0Datas = new HashMap<String, Object>();

        try {
            exifIFD0Datas = getExifIFD0Datas(getMetadata(imageFile));
        } catch (ImageProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return exifIFD0Datas;
    }

    private Map<String, Object> getExifIFD0Datas(Metadata metadata){

        Map<String, Object> exifIFD0Datas = new HashMap<String, Object>();

        Collection<ExifIFD0Directory> exifIFD0Directories = metadata.getDirectoriesOfType(ExifIFD0Directory.class);

        if (exifIFD0Directories != null){
            for (ExifIFD0Directory exifIFD0Directory: exifIFD0Directories) {

                String make = exifIFD0Directory.getString(ExifDirectoryBase.TAG_MAKE);
                if(make != null && !make.isEmpty()){
                    exifIFD0Datas.put(ImageMetadataManagerImpl.KEY_IMAGE_MAKE, make);
                }

                String model = exifIFD0Directory.getString(ExifDirectoryBase.TAG_MODEL);
                if(model != null && !model.isEmpty()){
                    exifIFD0Datas.put(ImageMetadataManagerImpl.KEY_IMAGE_MODEL, model);
                }

                Rational xRes = exifIFD0Directory.getRational(ExifDirectoryBase.TAG_X_RESOLUTION);
                if(xRes != null && xRes.isInteger()){
                    exifIFD0Datas.put(ImageMetadataManagerImpl.KEY_IMAGE_X_RESOLUTION, xRes.intValue());
                }

                Rational yRes = exifIFD0Directory.getRational(ExifDirectoryBase.TAG_Y_RESOLUTION);
                if(yRes != null && yRes.isInteger()){
                    exifIFD0Datas.put(ImageMetadataManagerImpl.KEY_IMAGE_Y_RESOLUTION, yRes.intValue());
                }

                Integer orientation = exifIFD0Directory.getInteger(ExifDirectoryBase.TAG_ORIENTATION);
                if(orientation != null){

                    String orientationString = "";
                    switch (orientation){
                        case 1 : orientationString = orientationMap[0]; break;
                        case 2 : orientationString = orientationMap[1]; break;
                        case 3 : orientationString = orientationMap[2]; break;
                        case 4 : orientationString = orientationMap[3]; break;
                        case 5 : orientationString = orientationMap[4]; break;
                        case 6 : orientationString = orientationMap[5]; break;
                        case 7 : orientationString = orientationMap[6]; break;
                        case 8 : orientationString = orientationMap[7]; break;
                        default: orientationString = "";
                    }

                    if(orientationString != null && !orientationString.isEmpty()) {
                        exifIFD0Datas.put(ImageMetadataManagerImpl.KEY_IMAGE_ORIENTATION, orientationString);
                    }
                }
            }
        }

        return exifIFD0Datas;
    }

    public Map<String, Object> getExifSubIFDDatas(String imagePath){

        File imageFile = new File(imagePath);

        return getExifSubIFDDatas(imageFile);
    }

    public Map<String, Object> getExifSubIFDDatas(File imageFile){

        Map<String, Object> exifSubIFDDatas = new HashMap<String, Object>();

        try {
            exifSubIFDDatas = getExifSubIFDDatas(getMetadata(imageFile));
        } catch (ImageProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return exifSubIFDDatas;
    }

    private Map<String, Object> getExifSubIFDDatas(Metadata metadata){

        Map<String, Object> exifSubIFDDatas = new HashMap<String, Object>();

        Collection<ExifSubIFDDirectory> exifSubIFDDirectories = metadata.getDirectoriesOfType(ExifSubIFDDirectory.class);

        if(exifSubIFDDirectories != null){
            for (ExifSubIFDDirectory exifSubIFDDirectory: exifSubIFDDirectories) {

                Integer height = exifSubIFDDirectory.getInteger(ExifSubIFDDirectory.TAG_EXIF_IMAGE_HEIGHT);
                if(height != null){
                    exifSubIFDDatas.put(ImageMetadataManagerImpl.KEY_IMAGE_HEIGHT, height);
                }

                Integer width = exifSubIFDDirectory.getInteger(ExifSubIFDDirectory.TAG_EXIF_IMAGE_WIDTH);
                if(width != null){
                    exifSubIFDDatas.put(ImageMetadataManagerImpl.KEY_IMAGE_WIDTH, width);
                }


                Date createDate = exifSubIFDDirectory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
                if(createDate != null){
                    exifSubIFDDatas.put(ImageMetadataManagerImpl.KEY_IMAGE_DATE, createDate);
                }

                Integer flash = exifSubIFDDirectory.getInteger(ExifSubIFDDirectory.TAG_FLASH);
                if(flash != null){

                    StringBuilder flashStringBuilder = new StringBuilder();
                    if((flash.intValue() & 1) != 0) {
                        flashStringBuilder.append("Flash fired");
                    } else {
                        flashStringBuilder.append("Flash did not fire");
                    }

                    if((flash.intValue() & 4) != 0) {
                        if((flash.intValue() & 2) != 0) {
                            flashStringBuilder.append(", return detected");
                        } else {
                            flashStringBuilder.append(", return not detected");
                        }
                    }

                    if((flash.intValue() & 16) != 0) {
                        flashStringBuilder.append(", auto");
                    }

                    if((flash.intValue() & 64) != 0) {
                        flashStringBuilder.append(", red-eye reduction");
                    }

                    exifSubIFDDatas.put(ImageMetadataManagerImpl.KEY_IMAGE_FLASH, flashStringBuilder.toString());
                }
            }
        }

        return exifSubIFDDatas;
    }

    // allin

    public Map<String, Object> getExifDatas(String imagePath){

        File imageFile = new File(imagePath);

        return getExifDatas(imageFile);
    }

    public Map<String, Object> getExifDatas(File imageFile){

        Map<String, Object> exifDatas = new HashMap<String, Object>();

        try {
            Metadata metadata = getMetadata(imageFile);

            Map<String, Object> exifIFD0Datas = getExifIFD0Datas(metadata);
            Map<String, Object> exifSubIFDDatas = getExifSubIFDDatas(metadata);

            exifDatas.putAll(exifIFD0Datas);
            exifDatas.putAll(exifSubIFDDatas);

        } catch (ImageProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return exifDatas;
    }
}