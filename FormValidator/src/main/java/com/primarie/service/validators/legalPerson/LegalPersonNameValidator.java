package com.primarie.service.validators.legalPerson;

import com.primarie.service.FormValidationException;

public class LegalPersonNameValidator  {
    private String name;

    public LegalPersonNameValidator(String name) {
        this.name = name;
    }


    public void validate() throws FormValidationException {
        if (name == null) {
            throw new FormValidationException("Error ! You must add the name of the legal person !");

        }
        if (name.length() > 15) {
            throw new FormValidationException("Error ! You`ve exceeded the length of the name !");

        }
    }
}
