package hu.bme.demola.canon.service.iservice;


import hu.bme.demola.canon.entity.Image;
import hu.bme.demola.canon.entity.Tag;

import java.util.List;

public interface TagService {

    // canonservice

    void create(Tag tag);

    void edit(Tag tag);

    void remove(Tag tag);

    Tag findById(Object id);

    List<Tag> findAll();

    Tag findByName(String name);

    List<Tag> findAllByName(String name);

    List<Image> findTagImagesById(Object id);

    List<Image> findTagImagesByName(String name);
}
