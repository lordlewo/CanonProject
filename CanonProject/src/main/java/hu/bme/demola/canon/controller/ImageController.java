package hu.bme.demola.canon.controller;

import hu.bme.demola.canon.entity.dto.AlbumDto;
import hu.bme.demola.canon.entity.dto.ImageDto;
import hu.bme.demola.canon.entity.dto.TagDto;
import hu.bme.demola.canon.service.iservice.CanonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping(
        value = "/canon/rest"
)
public class ImageController {

    @Autowired
    private CanonService canonServiceManager;

    @RequestMapping(
            value = {"/image/file/{id}"},
            method = {RequestMethod.GET}
    )
    public ResponseEntity<InputStreamResource> getImage(@PathVariable Long id){

        ImageDto imageDto = canonServiceManager.getImageById(id);

        File imageFile = new File(imageDto.getHomeDirectory() + imageDto.getName() + imageDto.getMime().getSuffix());

        InputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(imageFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return ResponseEntity
                .ok()
                .contentLength(imageFile.length())
                .contentType(MediaType.valueOf(imageDto.getMime().getMimeType()))
                .body(new InputStreamResource(fileInputStream));
    }

    @RequestMapping(
            value = {"/image/{id}"},
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ImageDto getImageById(@PathVariable Long id){

        return canonServiceManager.getImageById(id);
    }

    @RequestMapping(
            value = {"/images"},
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public List<ImageDto> getImages(){

        return canonServiceManager.getImages();
    }

    @RequestMapping(
            value = {"/image/{id}/albums"},
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public List<AlbumDto> getImageAlbumsById(@PathVariable Long id){

        return canonServiceManager.getImageAlbumsById(id);
    }

    @RequestMapping(
            value = {"/image/{id}/tags"},
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public List<TagDto> getImageTagsById(@PathVariable Long id){

        return canonServiceManager.getImageTagsById(id);
    }

}
