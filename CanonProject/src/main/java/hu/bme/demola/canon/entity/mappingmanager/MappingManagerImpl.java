package hu.bme.demola.canon.entity.mappingmanager;

import hu.bme.demola.canon.entity.*;
import hu.bme.demola.canon.entity.dto.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope("singleton")
public class MappingManagerImpl implements MappingManager {

    @Autowired
    private ModelMapper modelMapper;

    // imagemapping

    public AlbumDto mapAlbumForImage(Album album) {
        return modelMapper.map(album, AlbumDto.class);
    }

    public List<AlbumDto> mapAlbumsForImage(List<Album> albums) {

        List<AlbumDto> albumDtos = new ArrayList<AlbumDto>();
        for (Album album: albums) {
            albumDtos.add(mapAlbumForImage(album));
        }

        return albumDtos;
    }

    public TagDto mapTagForImage(Tag tag) {
        return modelMapper.map(tag, TagDto.class);
    }

    public List<TagDto> mapTagsForImage(List<Tag> tags) {

        List<TagDto> tagDtos = new ArrayList<TagDto>();
        for (Tag tag: tags) {
            tagDtos.add(mapTagForImage(tag));
        }

        return tagDtos;
    }

    public ImageDto mapImageForImage(Image image) {

        ImageDto imageDto = modelMapper.map(image, ImageDto.class);
        imageDto.setAlbumList(mapAlbumsForImage(image.getAlbumList()));
        imageDto.setTagList(mapTagsForImage(image.getTagList()));

        return imageDto;
    }

    public List<ImageDto> mapImagesForImage(List<Image> images) {

        List<ImageDto> imageDtos = new ArrayList<ImageDto>();
        for (Image image: images) {
            imageDtos.add(mapImageForImage(image));
        }

        return imageDtos;
    }

    // albummappings

    public ImageDto mapImageForAlbum(Image image) {
        return modelMapper.map(image, ImageDto.class);
    }

    public List<ImageDto> mapImagesForAlbum(List<Image> images) {

        List<ImageDto> imageDtos = new ArrayList<ImageDto>();
        for (Image image: images) {
            imageDtos.add(mapImageForAlbum(image));
        }

        return imageDtos;
    }

    public AlbumDto mapAlbumForAlbum(Album album) {

        AlbumDto albumDto = modelMapper.map(album, AlbumDto.class);
        albumDto.setImageList(mapImagesForAlbum(album.getImageList()));

        return albumDto;
    }

    public List<AlbumDto> mapAlbumsForAlbum(List<Album> albums) {

        List<AlbumDto> albumDtos = new ArrayList<AlbumDto>();
        for (Album album: albums) {
            albumDtos.add(mapAlbumForAlbum(album));
        }

        return albumDtos;
    }

    // tagmappings

    public ImageDto mapImageForTag(Image image) {
        return mapImageForAlbum(image);
    }

    public List<ImageDto> mapImagesForTag(List<Image> images) {
        return mapImagesForAlbum(images);
    }

    public TagDto mapTagForTag(Tag tag) {

        TagDto tagDto = modelMapper.map(tag, TagDto.class);
        tagDto.setImageList(mapImagesForTag(tag.getImageList()));

        return tagDto;
    }

    public List<TagDto> mapTagsForTag(List<Tag> tags) {

        List<TagDto> tagDtos = new ArrayList<TagDto>();
        for (Tag tag: tags) {
            tagDtos.add(mapTagForTag(tag));
        }

        return tagDtos;
    }

    // mimemapping

    public MimeDto mapMime(Mime mime){
        return modelMapper.map(mime, MimeDto.class);
    }

    public List<MimeDto> mapMimes(List<Mime> mimes) {

        List<MimeDto> mimeDtos = new ArrayList<MimeDto>();
        for (Mime mime: mimes) {
            mimeDtos.add(mapMime(mime));
        }

        return mimeDtos;
    }

    // metadatamapping

    public MetadataDto mapMetadata(Metadata metadata){
        return modelMapper.map(metadata, MetadataDto.class);
    }

    public List<MetadataDto> mapMetadatas(List<Metadata> metadatas) {

        List<MetadataDto> metadataDtos = new ArrayList<MetadataDto>();
        for (Metadata metadata: metadatas) {
            metadataDtos.add(mapMetadata(metadata));
        }

        return metadataDtos;
    }
}
