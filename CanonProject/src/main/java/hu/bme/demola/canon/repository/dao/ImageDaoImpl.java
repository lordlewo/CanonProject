package hu.bme.demola.canon.repository.dao;

import hu.bme.demola.canon.entity.Album;
import hu.bme.demola.canon.entity.Image;
import hu.bme.demola.canon.entity.Tag;
import hu.bme.demola.canon.repository.AbstractDao;
import hu.bme.demola.canon.repository.idao.ImageDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Scope("singleton")
public class ImageDaoImpl extends AbstractDao<Image> implements ImageDao {

    public static final String ALBUMLIST_ATTRIBUTE_NAME = "albumList";
    public static final String TAGLIST_ATTRIBUTE_NAME = "tagList";

    @PersistenceContext
    private EntityManager entityManager;

    public ImageDaoImpl(){
        super(Image.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public Image findOneByIdWithAlbumsAndTags(Object id) {
        EntityGraph<Image> imageEntityGraph = getEntityManager().createEntityGraph(Image.class);
        imageEntityGraph.addAttributeNodes(ImageDaoImpl.ALBUMLIST_ATTRIBUTE_NAME, ImageDaoImpl.TAGLIST_ATTRIBUTE_NAME);

        Map<String, Object> hints = new HashMap<String, Object>();
        hints.put("javax.persistence.loadgraph", imageEntityGraph);

        return getEntityManager().find(Image.class, id, hints);
    }

    public List<Album> findOneAlbumsById(Object id){
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery(Image.class);

        Root<Image> image = query.from(Image.class);
        image.fetch(ImageDaoImpl.ALBUMLIST_ATTRIBUTE_NAME);

        Predicate condition = cb.equal(image.get("id"), id);
        query.where(condition);

        return ((Image)getEntityManager().createQuery(query.select(image)).getSingleResult()).getAlbumList();
    }

    public List<Tag> findOneTagsById(Object id) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery(Image.class);

        Root<Image> image = query.from(Image.class);
        image.fetch(ImageDaoImpl.TAGLIST_ATTRIBUTE_NAME);

        Predicate condition = cb.equal(image.get("id"), id);
        query.where(condition);

        return ((Image)getEntityManager().createQuery(query.select(image)).getSingleResult()).getTagList();
    }

    public List<Image> findAllWith(String attribute){
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery(Image.class);

        Root<Image> image = query.from(Image.class);
        image.fetch(attribute);

        return getEntityManager().createQuery(query.select(image)).getResultList();
    }

    // canonservice

    @Override
    public void create(Image image){
        super.create(image);
    }

    @Override
    public void edit(Image image){
        super.edit(image);
    }

    @Override
    public void remove(Image image){
        super.remove(image);
    }

    @Override
    public Image find(Object id) {
        return super.find(id);
    }

    @Override
    public List<Image> findAll() {
        return super.findAll();
    }

    public Image findByName(String name, String suffix) {

        return getEntityManager()
                .createNamedQuery("Image.findByName", Image.class)
                .setParameter("name", name)
                .setParameter("suffix", suffix)
                .getSingleResult();
    }

    public List<Image> findAllByName(String name){

        return getEntityManager()
                .createNamedQuery("Image.findAllByName", Image.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Album> findImageAlbumsById(Object id){

        List albums = getEntityManager()
                .createNamedQuery("Image.findAlbumsById", Collection.class)
                .setParameter("id", id)
                .getResultList();

        return albums;
    }

    public List<Album> findImageAlbumsByName(String name, String suffix){

        List albums = getEntityManager()
                .createNamedQuery("Image.findAlbumsByName", Collection.class)
                .setParameter("name", name)
                .setParameter("suffix", suffix)
                .getResultList();

        return albums;
    }

    public List<Tag> findImageTagsById(Object id){

        List tags = getEntityManager()
                .createNamedQuery("Image.findTagsById", Collection.class)
                .setParameter("id", id)
                .getResultList();

        return tags;
    }

    public List<Tag> findImageTagsByName(String name, String suffix){

        List tags = getEntityManager()
                .createNamedQuery("Image.findTagsByName", Collection.class)
                .setParameter("name", name)
                .setParameter("suffix", suffix)
                .getResultList();

        return tags;
    }

}
