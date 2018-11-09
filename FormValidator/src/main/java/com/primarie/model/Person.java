package com.primarie.model;

//@JsonDeserialize(as = IndividualPerson.class)
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
    protected IndividualPerson individualPerson;
    protected LegalPerson legalPerson;
    protected String telephone;
    protected Address address;

    public Person() {
    }

    ;

    public Person(String telephone, Address address) {
        this.telephone = telephone;
        this.address = address;
    }

    public IndividualPerson getIndividualPerson() {
        return individualPerson;
    }

    public void setIndividualPerson(IndividualPerson individualPerson) {
        this.individualPerson = individualPerson;
    }

    public LegalPerson getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(LegalPerson legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
