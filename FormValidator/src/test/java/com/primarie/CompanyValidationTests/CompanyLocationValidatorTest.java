package com.primarie.CompanyValidationTests;

import com.primarie.model.Address;
import com.primarie.model.Coordinates;
import com.primarie.model.Location;
import com.primarie.service.FormValidationException;
import com.primarie.service.validators.company.CompanyLocationValidator;
import org.junit.Test;

import static org.junit.Assert.fail;

public class CompanyLocationValidatorTest {
    CompanyLocationValidator companyLocationValidator;

    @Test
    public void testValidationSuccess() {

    }

    @Test
    public void testValidationLocation() {
        Coordinates coord = new Coordinates(23, 43, 45);
        Address adr = new Address(23, "str", "buc", "jud", "rom", "234");
        Location location = new Location("ceva", coord, adr);
        location.setAddress(null);
        boolean foundException = false;
        try {
            companyLocationValidator = new CompanyLocationValidator(location);
            companyLocationValidator.validate();

        } catch (FormValidationException e) {
            foundException = true;
        }
        if (foundException == false) {
            fail("Exception should be thrown!");
        }
    }
}
