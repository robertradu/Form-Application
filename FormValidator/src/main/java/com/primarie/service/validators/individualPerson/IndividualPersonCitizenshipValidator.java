package com.primarie.service.validators.individualPerson;

import com.primarie.service.FormValidationException;

public class IndividualPersonCitizenshipValidator  {
    private String citizenship;

    public IndividualPersonCitizenshipValidator(String citizenship) {
        this.citizenship = citizenship;
    }


    public void validate() throws FormValidationException {
        if (citizenship == null) {
            throw new FormValidationException("Error ! You must add a citizenship");

        }
    }
}
