package ro.uti.robert.model;

import com.primarie.model.Form;
import com.primarie.model.Person;

import javax.persistence.*;

@Entity
@Table(name = "validated_forms.address")
public class AddressDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected Integer number;
    protected String street;
    protected String city;
    protected String county;
    protected String country;
    protected String postalCode;

    public AddressDB() {
    }

    public AddressDB(Form form) {
        this.number = form.getLocation().getAddress().getNumber();
        this.street = form.getLocation().getAddress().getStreet();
        this.city = form.getLocation().getAddress().getCity();
        this.county = form.getLocation().getAddress().getCounty();
        this.country = form.getLocation().getAddress().getCountry();
        this.postalCode = form.getLocation().getAddress().getPostalCode();

    }

    public AddressDB(Person person) {
        this.number = person.getAddress().getNumber();
        this.street = person.getAddress().getStreet();
        this.city = person.getAddress().getCity();
        this.county = person.getAddress().getCounty();
        this.country = person.getAddress().getCountry();
        this.postalCode = person.getAddress().getPostalCode();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "AddressDB{" +
                "id=" + id +
                ", number=" + number +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", country='" + country + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
