package com.primarie.service.validators.hospital;

import com.primarie.service.FormValidationException;
import com.primarie.service.validators.FormValidator;

public class HospitalAuthorizationNrValidator implements FormValidator {
    private String authorizationNr;

    public HospitalAuthorizationNrValidator(String authorizationNr) {
        this.authorizationNr = authorizationNr;
    }

    @Override
    public void validate() throws FormValidationException {
        if (authorizationNr == null)
            throw new FormValidationException("Error ! You must add an authorization number !");

        if (authorizationNr.length() > 10)
            throw new FormValidationException("Error! You`ve exceeded the length of the authorization number field !");

        if (!(authorizationNr.matches("[0-9]+") | (authorizationNr.matches("[-/]")))) {
            throw new FormValidationException("Error ! Authorization number must contain specified characters !");

        }
    }
}
