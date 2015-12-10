package hu.bme.demola.canon.entity.mappingmanager;

import hu.bme.demola.canon.entity.*;
import hu.bme.demola.canon.entity.dto.*;

import java.util.List;

public interface MappingManager {

    // imagemappings

    AlbumDto mapAlbumForImage(Album album);

    List<AlbumDto> mapAlbumsForImage(List<Album> albums);

    TagDto mapTagForImage(Tag tag);

    List<TagDto> mapTagsForImage(List<Tag> tags);

    ImageDto mapImageForImage(Image image);

    List<ImageDto> mapImagesForImage(List<Image> images);


    // albummappings

    ImageDto mapImageForAlbum(Image image);

    List<ImageDto> mapImagesForAlbum(List<Image> images);

    AlbumDto mapAlbumForAlbum(Album album);

    List<AlbumDto> mapAlbumsForAlbum(List<Album> albums);


    // tagmappings

    ImageDto mapImageForTag(Image image);

    List<ImageDto> mapImagesForTag(List<Image> images);

    TagDto mapTagForTag(Tag tag);

    List<TagDto> mapTagsForTag(List<Tag> tags);


    // mimemapping

    MimeDto mapMime(Mime mime);

    List<MimeDto> mapMimes(List<Mime> mimes);


    // metadatamapping

    MetadataDto mapMetadata(Metadata metadata);

    List<MetadataDto> mapMetadatas(List<Metadata> metadatas);

}
