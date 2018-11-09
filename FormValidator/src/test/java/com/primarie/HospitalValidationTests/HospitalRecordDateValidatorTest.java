package com.primarie.HospitalValidationTests;

import com.primarie.service.FormValidationException;
import com.primarie.service.validators.hospital.HospitalRegistrationDateValidator;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.fail;

public class HospitalRecordDateValidatorTest {
    HospitalRegistrationDateValidator hospitalRegistrationDateValidator;

    @Test(expected = FormValidationException.class)
    public void testValidationDate() throws FormValidationException {
        LocalDateTime date = null;
        hospitalRegistrationDateValidator = new HospitalRegistrationDateValidator(date);
        hospitalRegistrationDateValidator.validate();

    }
}
