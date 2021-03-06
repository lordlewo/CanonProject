package hu.bme.demola.canon.entity.propmap;

import hu.bme.demola.canon.entity.dto.AlbumDto;
import hu.bme.demola.canon.entity.Album;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("singleton")
public class AlbumPropertyMap extends PropertyMap<Album, AlbumDto>{

    @Autowired
    private ModelMapper modelMapper;

    @PostConstruct
    public void init(){
        modelMapper.addMappings(this);
    }

    @Override
    protected void configure() {
        skip().setImageList(null);
    }
}
