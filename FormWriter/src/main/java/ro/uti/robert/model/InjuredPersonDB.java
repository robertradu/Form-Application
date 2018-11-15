package ro.uti.robert.model;

public class InjuredPersonDB {
    private Integer id;
    private Integer personId;


    public InjuredPersonDB(){}
    public InjuredPersonDB (PersonDB personDB){
        this.personId = personDB.getId();
        this.id++;
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
}
