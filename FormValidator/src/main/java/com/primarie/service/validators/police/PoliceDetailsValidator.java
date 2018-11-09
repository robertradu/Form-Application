package com.primarie.service.validators.police;

import com.primarie.service.FormValidationException;
import com.primarie.service.validators.FormValidator;

public class PoliceDetailsValidator implements FormValidator {
    private String details;

    public PoliceDetailsValidator(String details) {
        this.details = details;


    }

    @Override
    public void validate() throws FormValidationException {
        if (details == null)
            throw new FormValidationException("Error ! You must add details");

        if (details.length() > 30)
            throw new FormValidationException("Error ! You must add details");

    }
}
