package hu.bme.demola.canon.repository.idao;


import hu.bme.demola.canon.entity.Album;
import hu.bme.demola.canon.entity.Image;

import java.util.List;

public interface AlbumDao {

    // canonservice

    void create(Album album);

    void edit(Album album);

    void remove(Album album);

    Album find(Object id);

    List<Album> findAll();

    Album findByName(String name);

    List<Album> findAllByName(String name);

    List<Image> findAlbumImagesById(Object id);

    List<Image> findAlbumImagesByName(String name);
}
