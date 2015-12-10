package hu.bme.demola.canon.service.iservice;


import hu.bme.demola.canon.entity.Mime;

import java.util.List;

public interface MimeService {

    void create(Mime mime);

    void edit(Mime mime);

    void remove(Mime mime);

    Mime findById(Object id);

    List<Mime> findAll();
}
