package com.primarie.tests.policeValidators;

import com.primarie.service.FormValidationException;
import com.primarie.service.validators.police.PoliceRegistrationDateValidator;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.fail;

public class PoliceRecordDateValidationTest {
    PoliceRegistrationDateValidator policeRegistrationDateValidator;

    @Test(expected = FormValidationException.class)
    public void testValidationDate() throws FormValidationException {
        LocalDateTime date = null;
        policeRegistrationDateValidator = new PoliceRegistrationDateValidator(date);
        policeRegistrationDateValidator.validate();

    }
}
