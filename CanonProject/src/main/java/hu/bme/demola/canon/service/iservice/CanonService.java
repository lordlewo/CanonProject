package hu.bme.demola.canon.service.iservice;

import hu.bme.demola.canon.entity.Image;
import hu.bme.demola.canon.entity.dto.AlbumDto;
import hu.bme.demola.canon.entity.dto.ImageDto;
import hu.bme.demola.canon.entity.dto.TagDto;

import java.util.List;

public interface CanonService {

    // image

    ImageDto getImageById(Object id);

    List<ImageDto> getImages();

    ImageDto getImageByName(String name, String suffix);

    List<ImageDto> getImagesByName(String name);

    List<AlbumDto> getImageAlbumsById(Object id);

    List<AlbumDto> getImageAlbumsByName(String name, String suffix);

    List<TagDto> getImageTagsById(Object id);

    List<TagDto> getImageTagsByName(String name, String suffix);

    void create(Image image);

    void edit(Image image);

    void remove(Image image);


    // album

    AlbumDto getAlbumById(Object id);

    List<AlbumDto> getAlbums();

    AlbumDto getAlbumByName(String name);

    List<AlbumDto> getAlbumsByName(String name);

    //--

    List<ImageDto> getAlbumImagesById(Object id);

    List<ImageDto> getAlbumImagesByName(String name);


    // tag

    TagDto getTagById(Object id);

    List<TagDto> getTags();

    TagDto getTagByName(String name);

    List<TagDto> getTagsByName(String name);

    //--

    List<ImageDto> getTagImagesById(Object id);

    List<ImageDto> getTagImagesByName(String name);

}
