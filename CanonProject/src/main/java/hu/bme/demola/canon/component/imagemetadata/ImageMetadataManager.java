package hu.bme.demola.canon.component.imagemetadata;

import com.drew.lang.GeoLocation;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface ImageMetadataManager {

    GeoLocation getGeoLocation(String imagePath);

    GeoLocation getGeoLocation(File imageFile);

    List<GeoLocation> getGeoLocations(String imagePath);

    List<GeoLocation> getGeoLocations(File imageFile);

    Map<String, Object> getExifIFD0Datas(String imagePath);

    Map<String, Object> getExifIFD0Datas(File imageFile);

    Map<String, Object> getExifSubIFDDatas(String imagePath);

    Map<String, Object> getExifSubIFDDatas(File imageFile);

    Map<String, Object> getExifDatas(String imagePath);

    Map<String, Object> getExifDatas(File imageFile);

}
