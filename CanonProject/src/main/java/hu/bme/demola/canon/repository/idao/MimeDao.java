package hu.bme.demola.canon.repository.idao;


import hu.bme.demola.canon.entity.Mime;

import java.util.List;

public interface MimeDao {

    void create(Mime mime);

    void edit(Mime mime);

    void remove(Mime mime);

    Mime find(Object id);

    List<Mime> findAll();
}
