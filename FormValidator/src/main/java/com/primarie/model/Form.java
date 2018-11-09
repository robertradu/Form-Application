package com.primarie.model;

import com.primarie.service.FormValidationException;
import com.primarie.service.validators.FormValidatorFactory;
import com.primarie.service.validators.person.PersonValidator;

import java.time.LocalDateTime;

public abstract class Form {
    protected Person applicant;
    protected String details;
    protected Location location;
    protected String data;
    protected LocalDateTime recordDate;


    public void validate() throws FormValidationException {
        FormValidatorFactory vF = new FormValidatorFactory();
        vF.getValidator(this);
        PersonValidator personValidator = new PersonValidator(applicant);
    }

    public Form() {

    }

    public Form(Person applicant, String details, Location location, String data) {
        this.applicant = applicant;
        this.details = details;
        this.location = location;
        this.data = data;
        this.recordDate = LocalDateTime.parse(this.data);
    }

    public Person getApplicant() {
        return applicant;
    }

    public void setApplicant(Person applicant) {
        this.applicant = applicant;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public LocalDateTime getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String data) {
        this.recordDate = LocalDateTime.parse(data);
    }


}
