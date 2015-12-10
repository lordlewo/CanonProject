package hu.bme.demola.canon.service;

import hu.bme.demola.canon.entity.Album;
import hu.bme.demola.canon.entity.Image;
import hu.bme.demola.canon.repository.idao.AlbumDao;
import hu.bme.demola.canon.service.iservice.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
@Scope("singleton")
public class AlbumServiceImpl implements AlbumService{

    @Autowired
    private AlbumDao albumDao;


    public void create(Album album) {
        albumDao.create(album);
    }

    public void edit(Album album) {
        albumDao.edit(album);
    }

    public void remove(Album album) {
        albumDao.edit(album);
    }

    public Album findById(Object id) {
        return albumDao.find(id);
    }

    public List<Album> findAll() {
        return albumDao.findAll();
    }

    public Album findByName(String name) {
        return albumDao.findByName(name);
    }

    public List<Album> findAllByName(String name) {
        return albumDao.findAllByName(name);
    }

    public List<Image> findAlbumImagesById(Object id) {
        return albumDao.findAlbumImagesById(id);
    }

    public List<Image> findAlbumImagesByName(String name) {
        return albumDao.findAlbumImagesByName(name);
    }
}
