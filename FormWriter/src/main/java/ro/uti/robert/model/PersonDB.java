package ro.uti.robert.model;

import com.primarie.model.Person;

public class PersonDB {
    private Integer id;
    private Integer individualPersonId;
    private Integer legalPersonId;
    private String telephone;
    private Integer addressId;


    public PersonDB() {
    }

    public PersonDB(Person person, IndividualPersonDB individualPersonDB, LegalPersonDB legalPersonDB, AddressDB addressDB) {
        this.individualPersonId = individualPersonDB.getId();
        this.legalPersonId = legalPersonDB.getId();
        this.telephone = person.getTelephone();
        this.addressId = addressDB.getId();
        this.id++;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIndividualPersonId() {
        return individualPersonId;
    }

    public void setIndividualPersonId(Integer individualPersonId) {
        this.individualPersonId = individualPersonId;
    }

    public Integer getLegalPersonId() {
        return legalPersonId;
    }

    public void setLegalPersonId(Integer legalPersonId) {
        this.legalPersonId = legalPersonId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
}
