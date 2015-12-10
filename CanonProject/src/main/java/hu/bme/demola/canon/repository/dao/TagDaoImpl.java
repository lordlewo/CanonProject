package hu.bme.demola.canon.repository.dao;

import hu.bme.demola.canon.entity.Image;
import hu.bme.demola.canon.entity.Tag;
import hu.bme.demola.canon.repository.AbstractDao;
import hu.bme.demola.canon.repository.idao.TagDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

@Repository
@Scope("singleton")
public class TagDaoImpl extends AbstractDao<Tag> implements TagDao{

    @PersistenceContext
    private EntityManager entityManager;

    public TagDaoImpl() {
        super(Tag.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public void create(Tag entity) {
        super.create(entity);
    }

    @Override
    public void edit(Tag entity) {
        super.edit(entity);
    }

    @Override
    public void remove(Tag entity) {
        super.remove(entity);
    }

    @Override
    public Tag find(Object id) {
        return super.find(id);
    }

    @Override
    public List<Tag> findAll() {
        return super.findAll();
    }

    public Tag findByName(String name) {

        return getEntityManager()
                .createNamedQuery("Tag.findByName", Tag.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    public List<Tag> findAllByName(String name) {

        return getEntityManager()
                .createNamedQuery("Image.findAllByName", Tag.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Image> findTagImagesById(Object id) {

        List images = getEntityManager()
                .createNamedQuery("Tag.findImagesById", Collection.class)
                .setParameter("id", id)
                .getResultList();

        return images;
    }

    public List<Image> findTagImagesByName(String name) {

        List images = getEntityManager()
                .createNamedQuery("Tag.findImagesByName", Collection.class)
                .setParameter("name", name)
                .getResultList();

        return images;
    }
}
