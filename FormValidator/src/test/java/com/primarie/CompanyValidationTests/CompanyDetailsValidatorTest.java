package com.primarie.CompanyValidationTests;

import com.primarie.service.FormValidationException;
import com.primarie.service.validators.company.CompanyDetailsValidator;
import org.junit.Test;

import static org.junit.Assert.fail;

public class CompanyDetailsValidatorTest {
    CompanyDetailsValidator companyDetailsValidator;

    @Test
    public void testValidationSuccess() {

    }

    @Test
    public void testValidationDetails(){
        String detalii = null;
        boolean hasException = false;
        try{
            companyDetailsValidator = new CompanyDetailsValidator(detalii);
            companyDetailsValidator.validate();
        } catch (FormValidationException e){
            hasException = true;
        }
        if (hasException == false) {
            fail("Exception should be thrown!");
        }
    }

    @Test(expected = FormValidationException.class)
    public void testValidationDetailsLength() throws FormValidationException {
        String detalii = "gregertgrehertt4333333333333333333333333333333333333333333herthreth";

            companyDetailsValidator = new CompanyDetailsValidator(detalii);
            companyDetailsValidator.validate();

    }
}
