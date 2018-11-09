package com.primarie.service.validators.person;

import com.primarie.model.Address;
import com.primarie.service.FormValidationException;
import com.primarie.service.validators.FormValidator;

public class AddressValidator implements FormValidator {
    private Address address;

    public AddressValidator(Address address) {
        this.address = address;
    }

    @Override
    public void validate() throws FormValidationException {
        if(address == null){
            throw new FormValidationException("Error ! You must insert an address !");
        }
        if (address.getNumber() == 0) {
            throw new FormValidationException("Error ! The address must have a number !");
        }
        if (address.getStreet() == null) {
            throw new FormValidationException("Error ! The address must have a street !");
        }
        if (address.getCity() == null) {
            throw new FormValidationException("Error ! The address must have a city !");
        }
        if (address.getCounty() == null) {
            throw new FormValidationException("Error ! The address must have a county !");
        }
        if (address.getCountry() == null) {
            throw new FormValidationException("Error ! The address must have a country !");
        }
        if (address.getPostalCode() == null) {
            throw new FormValidationException("Error ! The address must have a postal code !");
        }


    }
}
