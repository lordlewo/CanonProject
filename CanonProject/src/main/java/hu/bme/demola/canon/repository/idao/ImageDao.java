package hu.bme.demola.canon.repository.idao;


import hu.bme.demola.canon.entity.Album;
import hu.bme.demola.canon.entity.Image;
import hu.bme.demola.canon.entity.Tag;

import java.util.List;

public interface ImageDao {

    Image findOneByIdWithAlbumsAndTags(Object id);

    List<Album> findOneAlbumsById(Object id);

    List<Tag> findOneTagsById(Object id);

    List<Image> findAllWith(String attribute);


    // canonservice

    void create(Image image);

    void edit(Image image);

    void remove(Image image);

    Image find(Object id);

    List<Image> findAll();

    Image findByName(String name, String suffix);

    List<Image> findAllByName(String name);

    List<Album> findImageAlbumsById(Object id);

    List<Album> findImageAlbumsByName(String name, String suffix);

    List<Tag> findImageTagsById(Object id);

    List<Tag> findImageTagsByName(String name, String suffix);

}
