package ro.uti.robert.model;

import com.primarie.model.Person;

public class LegalPersonDB {
    private Integer id;
    private String name;
    private String cif;


    public LegalPersonDB() {
    }

    public LegalPersonDB(Person person) {
        this.name = person.getLegalPerson().getName();
        this.cif = person.getLegalPerson().getCif();
        this.id++;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    @Override
    public String toString() {
        return "LegalPersonDB{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cif='" + cif + '\'' +
                '}';
    }
}
