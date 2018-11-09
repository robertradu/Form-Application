package com.primarie.HospitalValidationTests;

import com.primarie.model.Address;
import com.primarie.model.Coordinates;
import com.primarie.model.Location;
import com.primarie.service.FormValidationException;
import com.primarie.service.validators.hospital.HospitalLocationValidator;
import org.junit.Test;

import static org.junit.Assert.fail;

public class HospitalLocationValidatorTest {
    HospitalLocationValidator hospitalLocationValidator;

    @Test
    public void testValidationLocation() {
        Coordinates coord = new Coordinates(23,43,45);
        Address adr = new Address(23, "str","buc","jud","rom","234");
        Location location = new Location("ceva",coord, adr);
        location.setAddress(null);
        boolean foundException = false;
        try {
            hospitalLocationValidator = new HospitalLocationValidator(location);
            hospitalLocationValidator.validate();

        } catch (FormValidationException e) {
            foundException = true;
        }
        if (foundException == false) {
            fail("Exception should be thrown!");
        }
    }
}
