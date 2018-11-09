package com.primarie.model;


//@JsonDeserialize(as = Person.class)
public class LegalPerson {
    protected String name;
    protected String cif;

    public LegalPerson(String name, String cif) {
        this.name = name;
        this.cif = cif;
    }

    public LegalPerson() {
    }

    ;

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
