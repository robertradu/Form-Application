package com.primarie.model;

import java.time.LocalDateTime;

public class HospitalForm extends StateForm {
    protected Person pacient;
    protected String equipment;

    public HospitalForm(Person applicant, String details, String authorizationNr, Location location, Person pacient, String equipment, String data) {
        this.applicant = applicant;
        this.details = details;
        this.authorizationNr = authorizationNr;
        this.location = location;
        this.pacient = pacient;
        this.equipment = equipment;
        this.data = data;
        this.recordDate = LocalDateTime.parse(data);
    }

    public HospitalForm() {
    }

    ;

    public Person getPerson() {
        return pacient;
    }

    public void setPerson(Person pacient) {
        this.pacient = pacient;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }


}
