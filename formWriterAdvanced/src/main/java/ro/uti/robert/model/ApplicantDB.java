package ro.uti.robert.model;

import javax.persistence.*;

@Entity
@Table(name = "validated_forms.applicant")
public class ApplicantDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "individualperson_id")
    private Integer individualPersonId;
    @Column(name = "legalperson_id")
    private Integer legalPersonId;


    public ApplicantDB() {
    }

    public ApplicantDB(PersonDB personDB) {
        this.individualPersonId = personDB.getIndividualPersonId();
        this.legalPersonId = personDB.getLegalPersonId();

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

    @Override
    public String toString() {
        return "ApplicantDB{" +
                "id=" + id +
                ", individualPersonId=" + individualPersonId +
                ", legalPersonId=" + legalPersonId +
                '}';
    }
}
