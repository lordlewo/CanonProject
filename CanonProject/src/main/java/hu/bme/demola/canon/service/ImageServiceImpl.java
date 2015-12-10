package hu.bme.demola.canon.service;


import hu.bme.demola.canon.entity.Album;
import hu.bme.demola.canon.entity.Image;
import hu.bme.demola.canon.entity.Tag;
import hu.bme.demola.canon.repository.dao.ImageDaoImpl;
import hu.bme.demola.canon.repository.idao.ImageDao;
import hu.bme.demola.canon.service.iservice.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
@Scope("singleton")
public class ImageServiceImpl implements ImageService{

    @Autowired
    private ImageDao imageDao;


    public Image findOneByIdWithAlbumsAndTags(Object id){
        return imageDao.findOneByIdWithAlbumsAndTags(id);
    }

    public List<Album> findOneAlbumsById(Object id){
        return imageDao.findOneAlbumsById(id);
    }

    public List<Tag> findOneTagsById(Object id){
        return imageDao.findOneTagsById(id);
    }

    public List<Image> findAllWithAlbums(){
        return imageDao.findAllWith(ImageDaoImpl.ALBUMLIST_ATTRIBUTE_NAME);
    }

    public List<Image> findAllWithTags(){
        return imageDao.findAllWith(ImageDaoImpl.TAGLIST_ATTRIBUTE_NAME);
    }

    public List<Image> findAllWithAlbumsAndTags(){
        List<Image> imageListWithAlbums = imageDao.findAllWith(ImageDaoImpl.ALBUMLIST_ATTRIBUTE_NAME);
        List<Image> imageListWithTags = imageDao.findAllWith(ImageDaoImpl.TAGLIST_ATTRIBUTE_NAME);

        List<Image> allList = new ArrayList<Image>();

        for (Image i: imageListWithAlbums) {
            allList.add(i);
        }

        for (int i = 0; i < allList.size(); i++) {
            allList.get(i).setTagList(imageListWithTags.get(i).getTagList());
        }

        return allList;
    }

    //canonservice

    public void create(Image image){
        imageDao.create(image);
    }

    public void edit(Image image){
        imageDao.edit(image);
    }

    public void remove(Image image){
        imageDao.edit(image);
    }

    public Image findById(Object id){
        return imageDao.find(id);
    }

    public List<Image> findAll(){
        return imageDao.findAll();
    }

    public Image findByName(String name, String suffix){
        return imageDao.findByName(name, suffix);
    }

    public List<Image> findAllByName(String name){
        return imageDao.findAllByName(name);
    }

    public List<Album> findImageAlbumsById(Object id){
        return imageDao.findImageAlbumsById(id);
    }

    public List<Album> findImageAlbumsByName(String name, String suffix){
        return imageDao.findImageAlbumsByName(name, suffix);
    }

    public List<Tag> findImageTagsById(Object id){
        return imageDao.findImageTagsById(id);
    }

    public List<Tag> findImageTagsByName(String name, String suffix){
        return imageDao.findImageTagsByName(name, suffix);
    }

}
