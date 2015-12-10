package hu.bme.demola.canon.repository.dao;


import hu.bme.demola.canon.entity.Album;
import hu.bme.demola.canon.entity.Image;
import hu.bme.demola.canon.repository.AbstractDao;
import hu.bme.demola.canon.repository.idao.AlbumDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

@Repository
@Scope("singleton")
public class AlbumDaoImpl extends AbstractDao<Album> implements AlbumDao {

    @PersistenceContext
    private EntityManager entityManager;

    public AlbumDaoImpl() {
        super(Album.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    // canonservice

    @Override
    public void create(Album album){
        super.create(album);
    }

    @Override
    public void edit(Album album){
        super.edit(album);
    }

    @Override
    public void remove(Album album){
        super.remove(album);
    }

    @Override
    public Album find(Object id) {
        return super.find(id);
    }

    @Override
    public List<Album> findAll() {
        return super.findAll();
    }

    public Album findByName(String name) {

        return getEntityManager()
                .createNamedQuery("Album.findByName", Album.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    public List<Album> findAllByName(String name) {

        return getEntityManager()
                .createNamedQuery("Album.findAllByName", Album.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Image> findAlbumImagesById(Object id) {

        List images = getEntityManager()
                .createNamedQuery("Album.findImagesById", Collection.class)
                .setParameter("id", id)
                .getResultList();

        return images;
    }

    public List<Image> findAlbumImagesByName(String name) {

        List images = getEntityManager()
                .createNamedQuery("Album.findImagesByName", Collection.class)
                .setParameter("name", name)
                .getResultList();

        return images;
    }
}
