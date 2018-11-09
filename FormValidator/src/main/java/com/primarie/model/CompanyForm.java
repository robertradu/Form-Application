package com.primarie.model;

import java.time.LocalDateTime;

public class CompanyForm extends PrivateForm {

    public CompanyForm(Person applicant, String details, Location location, String contractNr, String data) {
        this.applicant = applicant;
        this.details = details;
        this.location = location;
        this.contractNr = contractNr;
        this.data = data;
        this.recordDate = LocalDateTime.parse(data);

    }

    public CompanyForm() {
    }

    ;


}
