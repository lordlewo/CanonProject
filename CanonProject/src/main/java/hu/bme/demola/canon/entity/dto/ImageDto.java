package hu.bme.demola.canon.entity.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ImageDto implements Serializable{

    private String name;

    private String homeDirectory;

    private MimeDto mime;

    private MetadataDto metadata;

    @JsonManagedReference
    private List<AlbumDto> albumList;

    @JsonManagedReference
    private List<TagDto> tagList;

    public ImageDto() {
        albumList = new ArrayList<AlbumDto>();
        tagList = new ArrayList<TagDto>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomeDirectory() {
        return homeDirectory;
    }

    public void setHomeDirectory(String homeDirectory) {
        this.homeDirectory = homeDirectory;
    }

    public MimeDto getMime() {
        return mime;
    }

    public void setMime(MimeDto mime) {
        this.mime = mime;
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }

    public List<AlbumDto> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<AlbumDto> albumList) {
        this.albumList = albumList;
    }

    public List<TagDto> getTagList() {
        return tagList;
    }

    public void setTagList(List<TagDto> tagList) {
        this.tagList = tagList;
    }
}
