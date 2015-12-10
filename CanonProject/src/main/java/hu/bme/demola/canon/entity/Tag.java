package hu.bme.demola.canon.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tag")
@NamedQueries({
        @NamedQuery(name = "Tag.findByName", query = "select t from Tag t where lower(t.name) like lower(:name)"),
        @NamedQuery(name = "Tag.findAllByName", query = "select t from Tag t where lower(t.name) like concat('%',lower(:name),'%')"),
        @NamedQuery(name = "Tag.findImagesById", query = "select t.imageList from Tag t where t.id = :id"),
        @NamedQuery(name = "Tag.findImagesByName", query = "select t.imageList from Tag t where lower(t.name) like lower(:name)")
})
public class Tag implements Serializable{

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

    @ManyToMany(mappedBy = "tagList", cascade = {CascadeType.PERSIST})
    @JsonBackReference
    private List<Image> imageList;

    public Tag() {
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
