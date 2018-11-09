package com.primarie.tests.personValidators;

import com.primarie.service.FormValidationException;
import com.primarie.service.validators.person.TelephoneValidator;
import org.junit.Assert;
import org.junit.Test;

import java.text.Normalizer;

public class PersonTelephoneValidatorTest {
    private TelephoneValidator telephoneValidator;

    @Test
    public void testValidationTelephoneNumber() throws FormValidationException {
        boolean isDetected = false;
        try {
            String telephone = "03254";
            telephoneValidator = new TelephoneValidator(telephone);
            telephoneValidator.validate();
        } catch (FormValidationException e) {
            isDetected = true;
        }
        if (isDetected == false) {
            Assert.fail("Exception should be thrown !");
        }
    }
}
