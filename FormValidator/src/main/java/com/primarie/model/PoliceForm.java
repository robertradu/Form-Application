package com.primarie.model;

import java.time.LocalDateTime;

public class PoliceForm extends StateForm {
    protected Person injuredPerson;
    protected Person agent;

    public PoliceForm(Person applicant, String details, String authorizationNr, Location location, Person injuredPerson, Person agent, String data) {
        this.applicant = applicant;
        this.details = details;
        this.authorizationNr = authorizationNr;
        this.location = location;
        this.injuredPerson = injuredPerson;
        this.agent = agent;
        this.data = data;
        this.recordDate = LocalDateTime.parse(data);

    }

    public PoliceForm() {
    }

    ;


    public Person getAgent() {
        return agent;
    }

    public void setAgent(Person agent) {
        this.agent = agent;
    }

    public Person getPerson() {
        return injuredPerson;
    }

    public void setPerson(Person injuredPerson) {
        this.injuredPerson = injuredPerson;
    }

}


