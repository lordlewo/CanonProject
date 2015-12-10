package hu.bme.demola.canon.service.iservice;

import hu.bme.demola.canon.entity.Album;
import hu.bme.demola.canon.entity.Image;
import hu.bme.demola.canon.entity.Tag;

import java.util.List;

public interface ImageService {

    Image findOneByIdWithAlbumsAndTags(Object id);

    List<Album> findOneAlbumsById(Object id);

    List<Tag> findOneTagsById(Object id);

    List<Image> findAllWithAlbums();

    List<Image> findAllWithTags();

    List<Image> findAllWithAlbumsAndTags();

    // canonservice

    void create(Image image);

    void edit(Image image);

    void remove(Image image);

    Image findById(Object id);

    List<Image> findAll();

    Image findByName(String name, String suffix);

    List<Image> findAllByName(String name);

    List<Album> findImageAlbumsById(Object id);

    List<Album> findImageAlbumsByName(String name, String suffix);

    List<Tag> findImageTagsById(Object id);

    List<Tag> findImageTagsByName(String name, String suffix);

}
