package hu.bme.demola.canon.service;

import hu.bme.demola.canon.entity.Album;
import hu.bme.demola.canon.entity.Image;
import hu.bme.demola.canon.entity.Mime;
import hu.bme.demola.canon.entity.Tag;
import hu.bme.demola.canon.entity.dto.AlbumDto;
import hu.bme.demola.canon.entity.dto.ImageDto;
import hu.bme.demola.canon.entity.dto.MimeDto;
import hu.bme.demola.canon.entity.dto.TagDto;
import hu.bme.demola.canon.entity.mappingmanager.MappingManager;
import hu.bme.demola.canon.service.iservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
@Scope("singleton")
public class CanonServiceManager implements CanonService {

    @Autowired
    private MappingManager mappingManager;

    @Autowired
    private ImageService imageService;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private TagService tagService;

    @Autowired
    private MimeService mimeService;


    // image

    public void create(Image image){
        imageService.create(image);
    }

    public void edit(Image image){
        imageService.edit(image);
    }

    public void remove(Image image){
        imageService.remove(image);
    }

    public ImageDto getImageById(Object id) {
        Image image = imageService.findById(id);
        ImageDto imageDto = mappingManager.mapImageForImage(image);

        return imageDto;
    }

    public List<ImageDto> getImages(){
        List<Image> images = imageService.findAll();
        List<ImageDto> imageDtos = mappingManager.mapImagesForImage(images);

        return imageDtos;
    }

    public ImageDto getImageByName(String name, String suffix) {
        Image image = imageService.findByName(name, suffix);
        ImageDto imageDto = mappingManager.mapImageForImage(image);

        return imageDto;
    }

    public List<ImageDto> getImagesByName(String name) {
        List<Image> images = imageService.findAllByName(name);
        List<ImageDto> imageDtos = mappingManager.mapImagesForImage(images);

        return imageDtos;
    }

    public List<AlbumDto> getImageAlbumsById(Object id) {
        List<Album> albums = imageService.findImageAlbumsById(id);
        List<AlbumDto> albumDtos = mappingManager.mapAlbumsForImage(albums);

        return albumDtos;
    }

    public List<AlbumDto> getImageAlbumsByName(String name, String suffix) {
        List<Album> albums = imageService.findImageAlbumsByName(name, suffix);
        List<AlbumDto> albumDtos = mappingManager.mapAlbumsForImage(albums);

        return albumDtos;
    }

    public List<TagDto> getImageTagsById(Object id) {
        List<Tag> tags = imageService.findImageTagsById(id);
        List<TagDto> tagDtos = mappingManager.mapTagsForImage(tags);

        return tagDtos;
    }

    public List<TagDto> getImageTagsByName(String name, String suffix) {
        List<Tag> tags = imageService.findImageTagsByName(name, suffix);
        List<TagDto> tagDtos = mappingManager.mapTagsForImage(tags);

        return tagDtos;
    }


    // album

    public void create(Album album) {
        albumService.create(album);
    }

    public void edit(Album album) {
        albumService.edit(album);
    }

    public void remove(Album album) {
        albumService.edit(album);
    }

    public AlbumDto getAlbumById(Object id) {
        Album album = albumService.findById(id);
        AlbumDto albumDto = mappingManager.mapAlbumForAlbum(album);

        return albumDto;
    }

    public List<AlbumDto> getAlbums() {
        List<Album> albums = albumService.findAll();
        List<AlbumDto> albumDtos = mappingManager.mapAlbumsForAlbum(albums);

        return albumDtos;
    }

    public AlbumDto getAlbumByName(String name) {
        Album album = albumService.findByName(name);
        AlbumDto albumDto = mappingManager.mapAlbumForAlbum(album);

        return albumDto;
    }

    public List<AlbumDto> getAlbumsByName(String name) {
        List<Album> albums = albumService.findAllByName(name);
        List<AlbumDto> albumDtos = mappingManager.mapAlbumsForAlbum(albums);

        return albumDtos;
    }

    public List<ImageDto> getAlbumImagesById(Object id) {
        List<Image> images = albumService.findAlbumImagesById(id);
        List<ImageDto> imageDtos = mappingManager.mapImagesForAlbum(images);

        return imageDtos;
    }

    public List<ImageDto> getAlbumImagesByName(String name) {
        List<Image> images = albumService.findAlbumImagesByName(name);
        List<ImageDto> imageDtos = mappingManager.mapImagesForAlbum(images);

        return imageDtos;
    }


    // tag

    public void create(Tag tag) {
        tagService.create(tag);
    }

    public void edit(Tag tag) {
        tagService.edit(tag);
    }

    public void remove(Tag tag) {
        tagService.remove(tag);
    }

    public TagDto getTagById(Object id) {
        Tag tag = tagService.findById(id);
        TagDto tagDto = mappingManager.mapTagForTag(tag);

        return tagDto;
    }

    public List<TagDto> getTags() {
        List<Tag> tags = tagService.findAll();
        List<TagDto> tagDtos = mappingManager.mapTagsForTag(tags);

        return tagDtos;
    }

    public TagDto getTagByName(String name) {
        Tag tag = tagService.findByName(name);
        TagDto tagDto = mappingManager.mapTagForTag(tag);

        return tagDto;
    }

    public List<TagDto> getTagsByName(String name) {
        List<Tag> tags = tagService.findAllByName(name);
        List<TagDto> tagDtos = mappingManager.mapTagsForTag(tags);

        return tagDtos;
    }

    public List<ImageDto> getTagImagesById(Object id) {
        List<Image> images = tagService.findTagImagesById(id);
        List<ImageDto> imageDtos = mappingManager.mapImagesForTag(images);

        return imageDtos;
    }

    public List<ImageDto> getTagImagesByName(String name) {
        List<Image> images = tagService.findTagImagesByName(name);
        List<ImageDto> imageDtos = mappingManager.mapImagesForTag(images);

        return imageDtos;
    }


    // mime

    public void create(Mime mime) {
        mimeService.create(mime);
    }

    public void edit(Mime mime) {
        mimeService.edit(mime);
    }

    public void remove(Mime mime) {
        mimeService.remove(mime);
    }

    public MimeDto getMimeById(Object id) {
        Mime mime = mimeService.findById(id);
        MimeDto mimeDto = mappingManager.mapMime(mime);

        return mimeDto;
    }

    public List<MimeDto> getMimes(){
        List<Mime> mimes = mimeService.findAll();
        List<MimeDto> mimeDtos = mappingManager.mapMimes(mimes);

        return mimeDtos;
    }
}
