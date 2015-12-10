package hu.bme.demola.canon.service;


import hu.bme.demola.canon.entity.Image;
import hu.bme.demola.canon.entity.Tag;
import hu.bme.demola.canon.repository.idao.TagDao;
import hu.bme.demola.canon.service.iservice.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
@Scope("singleton")
public class TagServiceImpl implements TagService{

    @Autowired
    private TagDao tagDao;


    public void create(Tag tag) {
        tagDao.create(tag);
    }

    public void edit(Tag tag) {
        tagDao.edit(tag);
    }

    public void remove(Tag tag) {
        tagDao.remove(tag);
    }

    public Tag findById(Object id) {
        return tagDao.find(id);
    }

    public List<Tag> findAll() {
        return tagDao.findAll();
    }

    public Tag findByName(String name) {
        return tagDao.findByName(name);
    }

    public List<Tag> findAllByName(String name) {
        return tagDao.findAllByName(name);
    }

    public List<Image> findTagImagesById(Object id) {
        return tagDao.findTagImagesById(id);
    }

    public List<Image> findTagImagesByName(String name) {
        return tagDao.findTagImagesByName(name);
    }
}
