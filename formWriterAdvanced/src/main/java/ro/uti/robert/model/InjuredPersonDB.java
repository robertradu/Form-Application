package ro.uti.robert.model;

import javax.persistence.*;

@Entity
@Table(name = "validated_forms.injuredperson")
public class InjuredPersonDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "person_id")
    private Integer personId;


    public InjuredPersonDB() {
    }

    public InjuredPersonDB(PersonDB personDB) {
        this.personId = personDB.getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "InjuredPersonDB{" +
                "id=" + id +
                ", personId=" + personId +
                '}';
    }
}
