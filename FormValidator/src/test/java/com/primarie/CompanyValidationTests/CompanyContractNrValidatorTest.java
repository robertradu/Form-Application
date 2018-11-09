package com.primarie.CompanyValidationTests;

import com.primarie.service.FormValidationException;
import com.primarie.service.validators.company.CompanyContractNrValidator;
import org.junit.Test;

import static org.junit.Assert.fail;

public class CompanyContractNrValidatorTest {
    CompanyContractNrValidator companyContractNrValidator;

    @Test(expected = FormValidationException.class)
    public void testValidationNumber() throws FormValidationException {
        String nr = null;
        companyContractNrValidator = new CompanyContractNrValidator(nr);
        companyContractNrValidator.validate();

    }

    @Test(expected = FormValidationException.class)
    public void testValidationNumberLength() throws FormValidationException {
        String nr = "131313131313131232323213123";
        companyContractNrValidator = new CompanyContractNrValidator(nr);
        companyContractNrValidator.validate();

    }

    @Test(expected = FormValidationException.class)
    public void testValidationNumberMatches() throws FormValidationException {
        String nr = "dcasdasd";
        companyContractNrValidator = new CompanyContractNrValidator(nr);
        companyContractNrValidator.validate();


    }
}
