package com.primarie.service.validators.hospital;

import com.primarie.model.Person;
import com.primarie.service.FormValidationException;
import com.primarie.service.validators.FormValidator;
import com.primarie.service.validators.person.PersonValidator;

public class HospitalApplicantValidator implements FormValidator {
    private Person applicant;

    public HospitalApplicantValidator(Person applicant) {
        this.applicant = applicant;
    }

    @Override
    public void validate() throws FormValidationException {
        if ((applicant.getIndividualPerson() == null) && (applicant.getLegalPerson() == null)) {
            throw new FormValidationException("Error ! You must add a legal person or an individual person !");
        }
        new PersonValidator(applicant);

        if ((applicant.getIndividualPerson() != null) && (applicant.getLegalPerson() != null)) {
            throw new FormValidationException("Error ! You can not add both legal and individual person");

        }
    }
}
