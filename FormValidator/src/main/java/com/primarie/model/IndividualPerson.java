package com.primarie.model;

//@JsonDeserialize(as = Person.class)
public class IndividualPerson {
    protected String lastName;
    protected String firstName;
    protected String cnp;
    protected String citizenship;

    public IndividualPerson(String lastName, String firstName, String cnp, String citizenship) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.cnp = cnp;
        this.citizenship = citizenship;
    }

    public IndividualPerson() {
    }

    ;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String nume) {
        this.lastName = nume;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }
}
