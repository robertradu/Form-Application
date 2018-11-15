package ro.uti.robert.model;

import javax.persistence.*;

@Entity
@Table(name = "validated_forms.pacient")
public class PacientDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "individualperson_id")
    private Integer individualPersonId;

    public PacientDB() {
    }

    ;

    public PacientDB(IndividualPersonDB individualPersonDB) {
        this.individualPersonId = individualPersonDB.getId();
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

    @Override
    public String toString() {
        return "PacientDB{" +
                "id=" + id +
                ", individualPersonId=" + individualPersonId +
                '}';
    }
}
