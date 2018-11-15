package ro.uti.robert.model;

import com.primarie.model.Person;

public class LegalPersonDB {
    private Integer id;
    private String name;
    private String cif;


    public LegalPersonDB() {
    }

    public LegalPersonDB(Person person) {
       /* if(person == null){
            Person person1 = new Person();
            this.name = person1.getLegalPerson().getName();
            this.cif = person1.getLegalPerson().getCif();
            this.id++;
        }*/
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
}
