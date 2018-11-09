package com.primarie.service.validators.police;

import com.primarie.service.FormValidationException;
import com.primarie.service.validators.FormValidator;

public class PoliceAuthorizationNrValidator implements FormValidator {
    private String authorizationNr;

    public PoliceAuthorizationNrValidator(String authorizationNr) {
        this.authorizationNr = authorizationNr;

    }

    @Override
    public void validate() throws FormValidationException {
        if (authorizationNr == null)
            throw new FormValidationException("Error ! You must add an authorization number !");

        if (authorizationNr.length() > 10)
            throw new FormValidationException("Error! You`ve exceeded the length of the authorization number field !");
        if (!(authorizationNr.matches("[0-9]+"))) {
            throw new FormValidationException("Error ! The authorization number contains illegal characters !");

        }
    }
}
