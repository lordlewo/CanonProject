package hu.bme.demola.canon.repository.dao;


import hu.bme.demola.canon.entity.Mime;
import hu.bme.demola.canon.repository.AbstractDao;
import hu.bme.demola.canon.repository.idao.MimeDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Scope("singleton")
public class MimeDaoImpl extends AbstractDao<Mime> implements MimeDao {

    @PersistenceContext
    private EntityManager entityManager;

    public MimeDaoImpl() {
        super(Mime.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public void create(Mime mime){
        super.create(mime);
    }

    @Override
    public void edit(Mime mime){
        super.edit(mime);
    }

    @Override
    public void remove(Mime mime){
        super.remove(mime);
    }

    @Override
    public Mime find(Object id) {
        return super.find(id);
    }

    @Override
    public List<Mime> findAll() {
        return super.findAll();
    }
}
