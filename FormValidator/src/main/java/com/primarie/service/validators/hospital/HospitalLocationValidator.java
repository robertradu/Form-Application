package com.primarie.service.validators.hospital;

import com.primarie.model.Location;
import com.primarie.service.FormValidationException;
import com.primarie.service.validators.FormValidator;

public class HospitalLocationValidator implements FormValidator {
    private Location location;

    public HospitalLocationValidator(Location location) {
        this.location = location;
    }

    @Override
    public void validate() throws FormValidationException {
        if (location != null) {
            if (location.getAddress() == null) {
                throw new FormValidationException("Error ! You must add the address of the location !");

            }
        }
    }
}

