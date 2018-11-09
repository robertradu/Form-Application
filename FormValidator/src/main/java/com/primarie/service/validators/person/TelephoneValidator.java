package com.primarie.service.validators.person;

import com.primarie.service.FormValidationException;
import com.primarie.service.validators.FormValidator;

public class TelephoneValidator implements FormValidator {
    private String telephone;

    public TelephoneValidator(String telephone) throws FormValidationException {
        this.telephone = telephone;
       // validate();
    }

    @Override
    public void validate() throws FormValidationException {
        if (telephone != null) {
            if (telephone.length() != 10) {
                throw new FormValidationException("Error ! The telephone number does not have the right number of digits !");

            }
        }
    }


}
