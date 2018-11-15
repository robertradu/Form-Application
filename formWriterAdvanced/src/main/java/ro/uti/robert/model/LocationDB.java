package ro.uti.robert.model;

import com.primarie.model.Form;

import javax.persistence.*;

@Entity
@Table(name = "validated_forms.location")
public class LocationDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    @Column(name = "coordinates_id")
    private Integer coordinatesId;
    @Column(name = "address_id")
    private Integer addressId;

    public LocationDB() {
    }


    public LocationDB(Form form, CoordinatesDB coordinatesDB, AddressDB addressDB) {
        this.description = form.getLocation().getDescription();
        this.coordinatesId = coordinatesDB.getId();
        this.addressId = addressDB.getId();

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

    public void setCoordinatesId(Integer coordinates_Id) {
        this.coordinatesId = coordinates_Id;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer address_Id) {
        this.addressId = address_Id;
    }

    @Override
    public String toString() {
        return "LocationDB{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", coordinatesId=" + coordinatesId +
                ", addressId=" + addressId +
                '}';
    }
}
