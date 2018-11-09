package ro.uti.robert.model;

import com.primarie.model.Form;

public class LocationDB {
    private Integer id;
    private String description;
    private Integer coordinatesId;
    private Integer addressId;

    public LocationDB() {
    }


    public LocationDB(Form form, CoordinatesDB coordinatesDB, AddressDB addressDB) {
        this.description = form.getLocation().getDescription();
        this.coordinatesId = coordinatesDB.getId();
        this.addressId = addressDB.getId();
        id++;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCoordinatesId() {
        return coordinatesId;
    }

    public void setCoordinatesId(Integer coordinatesId) {
        this.coordinatesId = coordinatesId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
}
