package com.primarie.tests.policeValidators;

import com.primarie.service.FormValidationException;
import com.primarie.service.validators.police.PoliceDetailsValidator;
import org.junit.Test;

import static org.junit.Assert.fail;

public class PoliceDetailsValidatorTest {
    PoliceDetailsValidator policeDetailsValidator;

    @Test(expected = FormValidationException.class)
    public void testValidationDetails() throws FormValidationException {
        String details = null;
        policeDetailsValidator = new PoliceDetailsValidator(details);
        policeDetailsValidator.validate();

    }

    @Test(expected = FormValidationException.class)
    public void testValidationDetailsLength() throws FormValidationException {
        String details = "gregertg3232321312312312312reherther2222222222222222222threth";
        policeDetailsValidator = new PoliceDetailsValidator(details);
        policeDetailsValidator.validate();

    }
}
