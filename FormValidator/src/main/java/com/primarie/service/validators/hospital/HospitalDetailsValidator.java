package com.primarie.service.validators.hospital;

import com.primarie.service.FormValidationException;
import com.primarie.service.validators.FormValidator;

public class HospitalDetailsValidator implements FormValidator {

    private String details;

    public HospitalDetailsValidator(String details) {
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
