package com.primarie.service.validators.individualPerson;

import com.primarie.service.FormValidationException;

public class IndividualPersonLastNameValidator {
    private String lastName;

    public IndividualPersonLastNameValidator(String lastName) {
        this.lastName = lastName;
    }


    public void validate() throws FormValidationException {
        if (lastName == null) {
            throw new FormValidationException("Error ! You must add the last name !");

        }
        if (lastName.length() > 60) {
            throw new FormValidationException("Error! You`ve exceeded the length of the last name !");

        }
    }
}
