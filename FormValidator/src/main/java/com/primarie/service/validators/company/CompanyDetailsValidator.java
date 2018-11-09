package com.primarie.service.validators.company;

import com.primarie.service.FormValidationException;
import com.primarie.service.validators.FormValidator;

public class CompanyDetailsValidator implements FormValidator {
    private String details;

    public CompanyDetailsValidator(String details) {
        this.details = details;

    }

    @Override
    public void validate() throws FormValidationException {
        if (details == null)
            throw new FormValidationException("Error ! You must add details");
        if ((details.length() > 30))
            throw new FormValidationException("Error! You`ve exceeded the length of the details !");

    }
}
