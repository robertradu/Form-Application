package com.primarie.service.validators.police;

import com.primarie.service.FormValidationException;
import com.primarie.service.validators.FormValidator;

import java.time.LocalDateTime;

public class PoliceRegistrationDateValidator implements FormValidator {
    private LocalDateTime registrationDate;

    public PoliceRegistrationDateValidator(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public void validate() throws FormValidationException {
        if (registrationDate == null) {
            throw new FormValidationException("Error ! You must add a record date !");

        }
    }
}
