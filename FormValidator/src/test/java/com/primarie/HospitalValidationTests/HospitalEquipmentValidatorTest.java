package com.primarie.HospitalValidationTests;

import com.primarie.service.FormValidationException;
import com.primarie.service.validators.hospital.HospitalEquipmentValidator;
import org.junit.Test;

public class HospitalEquipmentValidatorTest {
    HospitalEquipmentValidator hospitalEquipmentValidator;

    @Test(expected = FormValidationException.class)
    public void testValidationEquipment() throws FormValidationException {
        String equipment = "ggggggggggggggggggggggggggghhhhhhhhhhhhhhjjjjjjjjjjjjjjjjjjjjjgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg";
        hospitalEquipmentValidator = new HospitalEquipmentValidator(equipment);
        hospitalEquipmentValidator.validate();

    }
}
