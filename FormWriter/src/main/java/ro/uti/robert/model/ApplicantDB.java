package ro.uti.robert.model;

public class ApplicantDB {
    private Integer id;
    private Integer individualPersonId;
    private Integer legalPersonId;


    public ApplicantDB() {
    }

    public ApplicantDB(PersonDB personDB) {
        this.individualPersonId = personDB.getIndividualPersonId();
        this.legalPersonId = personDB.getLegalPersonId();
        id++;
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
}
