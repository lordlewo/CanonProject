package hu.bme.demola.canon.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "metadata")
public class Metadata implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Basic(optional = false)
    @Column(name = "height", nullable = true)
    private int height; //pixel

    @Basic(optional = false)
    @Column(name = "width", nullable = true)
    private int width; //pixel

    @Basic(optional = false)
    @Column(name = "x_resolution", nullable = true)
    private int xResolution; //dpi

    @Basic(optional = false)
    @Column(name = "y_resolution", nullable = true)
    private int yResolution; //dpi

    @Basic(optional = false)
    @Column(name = "make", nullable = true)
    private String make;

    @Basic(optional = false)
    @Column(name = "model", nullable = true)
    private String model;

    @Basic(optional = false)
    @Column(name = "create_date", nullable = true)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createDate;

    @Basic(optional = false)
    @Column(name = "flash", nullable = true)
    private String flash;

    @Basic(optional = false)
    @Column(name = "orientation", nullable = true)
    private String orientation;

    @Basic(optional = false)
    @Column(name = "latitude", nullable = true)
    private int latitude;

    @Basic(optional = false)
    @Column(name = "longitude", nullable = true)
    private int longitude;

    @Basic(optional = false)
    @Column(name = "dominant_color", nullable = true)
    private String dominantColor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getxResolution() {
        return xResolution;
    }

    public void setxResolution(int xResolution) {
        this.xResolution = xResolution;
    }

    public int getyResolution() {
        return yResolution;
    }

    public void setyResolution(int yResolution) {
        this.yResolution = yResolution;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getFlash() {
        return flash;
    }

    public void setFlash(String flash) {
        this.flash = flash;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public String getDominantColor() {
        return dominantColor;
    }

    public void setDominantColor(String dominantColor) {
        this.dominantColor = dominantColor;
    }
}
