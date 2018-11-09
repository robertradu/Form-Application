package com.primarie.service.validators.hospital;

import com.primarie.service.FormValidationException;
import com.primarie.service.validators.FormValidator;

import java.time.LocalDateTime;

public class HospitalRegistrationDateValidator implements FormValidator {
    private LocalDateTime registrationDate;

    public HospitalRegistrationDateValidator(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public void validate() throws FormValidationException {
        if (registrationDate == null) {
            throw new FormValidationException("Error ! You must add a record date !");

        }
    }
}
