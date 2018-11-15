package ro.uti.robert.model;

import com.primarie.model.Person;

import javax.persistence.*;

@Entity
@Table(name = "validated_forms.person")
public class PersonDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "individual_person_id")
    private Integer individualPersonId;
    @Column(name = "legal_person_id")
    private Integer legalPersonId;
    private String telephone;
    @Column(name = "address_id")
    private Integer addressId;


    public PersonDB() {
    }

    public PersonDB(Person person, IndividualPersonDB individualPersonDB, LegalPersonDB legalPersonDB, AddressDB addressDB) {
        this.individualPersonId = individualPersonDB.getId();
        this.legalPersonId = legalPersonDB.getId();
        this.telephone = person.getTelephone();
        this.addressId = addressDB.getId();

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

    @Override
    public String toString() {
        return "PersonDB{" +
                "id=" + id +
                ", individualPersonId=" + individualPersonId +
                ", legalPersonId=" + legalPersonId +
                ", telephone='" + telephone + '\'' +
                ", addressId=" + addressId +
                '}';
    }
}
