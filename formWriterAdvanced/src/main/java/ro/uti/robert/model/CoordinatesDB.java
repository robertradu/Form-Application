package ro.uti.robert.model;

import com.primarie.model.Form;

import javax.persistence.*;

@Entity
@Table(name = "validated_forms.coordinates")
public class CoordinatesDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected Double altitude;
    protected Double longitude;
    protected Double latitude;


    public CoordinatesDB() {
    }

    ;

    public CoordinatesDB(Form form) {
        this.latitude = form.getLocation().getCoordinates().getLatitude();
        this.longitude = form.getLocation().getCoordinates().getLongitude();
        this.altitude = form.getLocation().getCoordinates().getAltitude();

    }


    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CoordinatesDB{" +
                "id=" + id +
                ", altitude=" + altitude +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
