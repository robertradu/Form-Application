package com.primarie.HospitalValidationTests;

import com.primarie.service.FormValidationException;
import com.primarie.service.validators.hospital.HospitalDetailsValidator;
import org.junit.Test;

import static org.junit.Assert.fail;

public class HospitalDetailsValidatorTest {
    HospitalDetailsValidator hospitalDetailsValidator;

    @Test(expected = FormValidationException.class)
    public void testValidationDetails() throws FormValidationException {
        String detalii = null;
        hospitalDetailsValidator = new HospitalDetailsValidator(detalii);
        hospitalDetailsValidator.validate();

    }

    @Test(expected = FormValidationException.class)
    public void testValidationDetailsLength() throws FormValidationException {
        String detalii = "gregertgrehernhgnrnrtynrtyntyrntrynrty6543y466therthreth";
        hospitalDetailsValidator = new HospitalDetailsValidator(detalii);
        hospitalDetailsValidator.validate();

    }
}
