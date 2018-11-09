package com.primarie.LegalPersonValidationTests;

import com.primarie.service.FormValidationException;
import com.primarie.service.validators.legalPerson.LegalPersonNameValidator;
import org.junit.Test;

import static org.junit.Assert.fail;

public class LegalPersonNameValidatorTest {
    LegalPersonNameValidator legalPersonNameValidator;


    @Test(expected = FormValidationException.class)
    public void testValidationName() throws FormValidationException {
        String nume = null;
        legalPersonNameValidator = new LegalPersonNameValidator(nume);
        legalPersonNameValidator.validate();

    }

    @Test(expected = FormValidationException.class)
    public void testValidationNameLength() throws FormValidationException {
        String nume = "treterterterterterterterter";
        legalPersonNameValidator = new LegalPersonNameValidator(nume);
        legalPersonNameValidator.validate();

    }
}
