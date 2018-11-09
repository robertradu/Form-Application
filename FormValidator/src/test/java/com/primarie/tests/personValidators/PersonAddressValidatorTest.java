package com.primarie.tests.personValidators;

import com.primarie.model.Address;
import com.primarie.service.FormValidationException;
import com.primarie.service.validators.person.AddressValidator;
import org.junit.Test;

public class PersonAddressValidatorTest {
    private AddressValidator addressValidator;

    @Test(expected = FormValidationException.class)
    public void testValidationAddressNumber() throws FormValidationException {

        Address address = new Address(0, "street", "city", "county", "country", "234");
        addressValidator = new AddressValidator(address);
        addressValidator.validate();
    }

    @Test(expected = FormValidationException.class)
    public void testValidationAddressStreet() throws FormValidationException {

        Address address = new Address(20, null, "city", "county", "country", "234");
        addressValidator = new AddressValidator(address);
        addressValidator.validate();
    }

    @Test(expected = FormValidationException.class)
    public void testValidationAddressCity() throws FormValidationException {

        Address address = new Address(20, "street", null, "county", "country", "234");
        addressValidator = new AddressValidator(address);
        addressValidator.validate();
    }

    @Test(expected = FormValidationException.class)
    public void testValidationAddressCounty() throws FormValidationException {

        Address address = new Address(20, "street", "city", null, "country", "234");
        addressValidator = new AddressValidator(address);
        addressValidator.validate();
    }

    @Test(expected = FormValidationException.class)
    public void testValidationAddressCountry() throws FormValidationException {

        Address address = new Address(0, "street", "city", "county", null, "234");
        addressValidator = new AddressValidator(address);
        addressValidator.validate();
    }

    @Test(expected = FormValidationException.class)
    public void testValidationAddressPostalCode() throws FormValidationException {

        Address address = new Address(20, "street", "city", "county", "country", null);
        addressValidator = new AddressValidator(address);
        addressValidator.validate();
    }


}
