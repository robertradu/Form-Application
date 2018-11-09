package com.primarie.HospitalValidationTests;

import com.primarie.service.FormValidationException;
import com.primarie.service.validators.hospital.HospitalAuthorizationNrValidator;
import org.junit.Test;

import static org.junit.Assert.fail;

public class HospitalAuthorizationNrValidatorTest {
    HospitalAuthorizationNrValidator hospitalAuthorizationNrValidator;

    @Test(expected = FormValidationException.class)
    public void testValidationNumber() throws FormValidationException {
        String nr = null;
        hospitalAuthorizationNrValidator = new HospitalAuthorizationNrValidator(nr);
        hospitalAuthorizationNrValidator.validate();
    }

    @Test(expected = FormValidationException.class)
    public void testValidationNumberLength() throws FormValidationException {
        String nr = "131313131313131232323213123";
        hospitalAuthorizationNrValidator = new HospitalAuthorizationNrValidator(nr);
        hospitalAuthorizationNrValidator.validate();

    }

    @Test(expected = FormValidationException.class)
    public void testValidationNumberMatches() throws FormValidationException {
        String nr = "dcasdasd";
        hospitalAuthorizationNrValidator = new HospitalAuthorizationNrValidator(nr);
        hospitalAuthorizationNrValidator.validate();


    }
}
