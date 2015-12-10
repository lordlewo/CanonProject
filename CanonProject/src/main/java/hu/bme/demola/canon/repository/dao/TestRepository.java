package hu.bme.demola.canon.repository.dao;

import hu.bme.demola.canon.entity.Test;
import hu.bme.demola.canon.repository.AbstractDao;
import hu.bme.demola.canon.repository.idao.TestRepo;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Scope("singleton")
@Transactional
public class TestRepository extends AbstractDao<Test> implements TestRepo{

    @PersistenceContext
    private EntityManager em;

    public TestRepository() {
        super(Test.class);
    }

    public void createTest(){

        Test test = new Test();
        test.setName("uuJJJ");
        getEntityManager().merge(test);

    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void create(Test entity) {
        super.create(entity);
    }
}
