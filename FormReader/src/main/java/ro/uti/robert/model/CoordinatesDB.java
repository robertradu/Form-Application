package ro.uti.robert.model;

import com.primarie.model.Form;
import com.primarie.model.HospitalForm;

public class CoordinatesDB {
    protected Integer id;
    protected Double altitude;
    protected Double longitude;
    protected Double latitude;

    public CoordinatesDB(){};

    public CoordinatesDB(Form form) {
        this.latitude = form.getLocation().getCoordinates().getLatitude();
        this.longitude = form.getLocation().getCoordinates().getLongitude();
        this.altitude = form.getLocation().getCoordinates().getAltitude();
        id++;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
