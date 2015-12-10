package hu.bme.demola.canon.entity.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.List;

public class AlbumDto implements Serializable{

    private String name;

    private String description;

    @JsonBackReference
    private List<ImageDto> imageList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ImageDto> getImageList() {
        return imageList;
    }

    public void setImageList(List<ImageDto> imageList) {
        this.imageList = imageList;
    }
}
