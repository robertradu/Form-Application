package com.primarie.service.validators.individualPerson;

import com.primarie.service.FormValidationException;

public class IndividualPersonFirstNameValidator  {
    private String firstName;

    public IndividualPersonFirstNameValidator(String firstName) {
        this.firstName = firstName;

    }


    public void validate() throws FormValidationException {
        if (firstName == null) {
            throw new FormValidationException("Error ! You must add the first name !");

        }

        if (firstName.length() > 100) {
            throw new FormValidationException("Error! You`ve exceeded the length of the first name !");

        }
    }
}
