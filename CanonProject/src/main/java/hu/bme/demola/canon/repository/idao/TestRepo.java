package hu.bme.demola.canon.repository.idao;


import hu.bme.demola.canon.entity.Test;

public interface TestRepo {

    void createTest();

    void create(Test entity);
}
