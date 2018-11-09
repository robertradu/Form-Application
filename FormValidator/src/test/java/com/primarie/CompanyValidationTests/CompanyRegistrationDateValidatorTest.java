package com.primarie.CompanyValidationTests;

import com.primarie.service.FormValidationException;
import com.primarie.service.validators.company.CompanyRegistrationDateValidator;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.fail;

public class CompanyRegistrationDateValidatorTest {
    CompanyRegistrationDateValidator companyRegistrationDateValidator;


    @Test (expected = FormValidationException.class)
    public void testValidationDate() throws FormValidationException{
        LocalDateTime date = null;

            companyRegistrationDateValidator = new CompanyRegistrationDateValidator(date);
            companyRegistrationDateValidator.validate();

    }
}
