package com.primarie.service.validators.hospital;

import com.primarie.service.FormValidationException;
import com.primarie.service.validators.FormValidator;

public class HospitalEquipmentValidator implements FormValidator {
    private String equipment;

    public HospitalEquipmentValidator(String equipment) {
        this.equipment = equipment;
    }


    @Override
    public void validate() throws FormValidationException {
        if (equipment != null) {
            if (equipment.length() > 50) {
                throw new FormValidationException("Error ! You`ve exceeded the length of the equipment field !");

            }
        }
    }
}

