package hu.bme.demola.canon.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "album")
@NamedQueries({
        @NamedQuery(name = "Album.findByName", query = "select a from Album a where lower(a.name) like lower(:name)"),
        @NamedQuery(name = "Album.findAllByName", query = "select a from Album a where lower(a.name) like concat('%',lower(:name),'%')"),
        @NamedQuery(name = "Album.findImagesById", query = "select a.imageList from Album a where a.id = :id"),
        @NamedQuery(name = "Album.findImagesByName", query = "select a.imageList from Album a where lower(a.name) like lower(:name)")
})
public class Album implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Basic(optional = false)
    @Column(name = "name", nullable = false)
    private String name;

    @Basic(optional = false)
    @Column(name = "description", nullable = false)
    private String description;

    @ManyToMany(mappedBy = "albumList", cascade = {CascadeType.PERSIST})
    private List<Image> imageList;

    public Album() {
        imageList = new ArrayList<Image>();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
}
