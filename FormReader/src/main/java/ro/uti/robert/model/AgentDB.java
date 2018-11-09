package ro.uti.robert.model;

public class AgentDB {
    private Integer id;
    private Integer individualPersonId;

    public AgentDB() {
    }

    public AgentDB(IndividualPersonDB individualPersonDB) {
        this.individualPersonId = individualPersonDB.getId();
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
}
