package ro.uti.robert.model;

import javax.persistence.*;

@Entity
@Table(name = "validated_forms.agent")
public class AgentDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "individualperson_id")
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

    @Override
    public String toString() {
        return "AgentDB{" +
                "id=" + id +
                ", individualPersonId=" + individualPersonId +
                '}';
    }
}
