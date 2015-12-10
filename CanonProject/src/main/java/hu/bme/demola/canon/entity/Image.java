package hu.bme.demola.canon.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "image")
@NamedQueries({
        @NamedQuery(name = "Image.findByName", query = "select i from Image i where concat(lower(i.name),lower(i.mime.suffix)) like concat(lower(:name),'.',lower(:suffix))"),
        @NamedQuery(name = "Image.findAllByName", query = "select i from Image i where lower(i.name) like concat('%',lower(:name),'%')"),
        @NamedQuery(name = "Image.findAlbumsById", query = "select i.albumList from Image i where i.id = :id"),
        @NamedQuery(name = "Image.findAlbumsByName", query = "select i.albumList from Image i where concat(lower(i.name),lower(i.mime.suffix)) like concat(lower(:name),'.',lower(:suffix))"),
        @NamedQuery(name = "Image.findTagsById", query = "select i.tagList from Image i where i.id = :id"),
        @NamedQuery(name = "Image.findTagsByName", query = "select i.tagList from Image i where concat(lower(i.name),lower(i.mime.suffix)) like concat(lower(:name),'.',lower(:suffix))"),
        @NamedQuery(name = "Image.findMetaDataById", query = "select i.metadata from Image i where i.id = :id"),
        @NamedQuery(name = "Image.findMetaDataByName", query = "select i.metadata from Image i where concat(lower(i.name),lower(i.mime.suffix)) like concat(lower(:name),'.',lower(:suffix))")
})
public class Image implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Basic(optional = false)
    @Column(name = "name", nullable = false)
    private String name;

    @Basic(optional = false)
    @Column(name = "home_direcory", nullable = false)
    private String homeDirectory;

    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "mime_id", nullable = false)
    private Mime mime;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "metadata_id", nullable = false)
    private Metadata metadata;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "album_mappings",
            joinColumns = {@JoinColumn(name = "image_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "album_id", referencedColumnName = "id")}
    )
    private List<Album> albumList;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "tag_mappings",
            joinColumns = {@JoinColumn(name = "image_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id", referencedColumnName = "id")}
    )
    private List<Tag> tagList;

    public Image() {
        albumList = new ArrayList<Album>();
        tagList = new ArrayList<Tag>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomeDirectory() {
        return homeDirectory;
    }

    public void setHomeDirectory(String homeDirectory) {
        this.homeDirectory = homeDirectory;
    }

    public Mime getMime() {
        return mime;
    }

    public void setMime(Mime mime) {
        this.mime = mime;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }
}
