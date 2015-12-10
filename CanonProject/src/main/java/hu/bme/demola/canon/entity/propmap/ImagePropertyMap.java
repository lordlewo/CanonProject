package hu.bme.demola.canon.entity.propmap;

import hu.bme.demola.canon.entity.Image;
import hu.bme.demola.canon.entity.dto.ImageDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("singleton")
public class ImagePropertyMap extends PropertyMap<Image, ImageDto>{

    @Autowired
    private ModelMapper modelMapper;

    @PostConstruct
    public void init(){
        modelMapper.addMappings(this);
    }

    @Override
    protected void configure() {
        skip().setAlbumList(null);
        skip().setTagList(null);
    }
}
