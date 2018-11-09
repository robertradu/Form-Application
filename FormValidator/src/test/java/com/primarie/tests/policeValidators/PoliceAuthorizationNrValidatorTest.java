package com.primarie.tests.policeValidators;

import com.primarie.service.FormValidationException;
import com.primarie.service.validators.police.PoliceAuthorizationNrValidator;
import org.junit.Test;

import static org.junit.Assert.fail;

public class PoliceAuthorizationNrValidatorTest {
    PoliceAuthorizationNrValidator policeAuthorizationNrValidator;

    @Test(expected = FormValidationException.class)
    public void testValidationNumber() throws FormValidationException {
        String nr = null;
        policeAuthorizationNrValidator = new PoliceAuthorizationNrValidator(nr);
        policeAuthorizationNrValidator.validate();

    }

    @Test(expected = FormValidationException.class)
    public void testValidationNumberLength() throws FormValidationException {
        String nr = "131313131313131232323213123";
        policeAuthorizationNrValidator = new PoliceAuthorizationNrValidator(nr);
        policeAuthorizationNrValidator.validate();

    }

    @Test(expected = FormValidationException.class)
    public void testValidationNumberMatches() throws FormValidationException {
        String nr = "dcasdasd";
        policeAuthorizationNrValidator = new PoliceAuthorizationNrValidator(nr);
        policeAuthorizationNrValidator.validate();
    }
}
