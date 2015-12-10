package hu.bme.demola.canon.service;


import hu.bme.demola.canon.entity.Mime;
import hu.bme.demola.canon.repository.idao.MimeDao;
import hu.bme.demola.canon.service.iservice.MimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
@Scope("singleton")
public class MimeServiceImpl implements MimeService {

    @Autowired
    private MimeDao mimeDao;


    public void create(Mime mime) {
        mimeDao.create(mime);
    }

    public void edit(Mime mime) {
        mimeDao.edit(mime);
    }

    public void remove(Mime mime) {
        mimeDao.remove(mime);
    }

    public Mime findById(Object id) {
        return mimeDao.find(id);
    }

    public List<Mime> findAll(){
        return mimeDao.findAll();
    }
}
