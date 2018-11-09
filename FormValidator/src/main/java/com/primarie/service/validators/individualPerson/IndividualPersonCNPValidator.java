package com.primarie.service.validators.individualPerson;

import com.primarie.service.FormValidationException;

public class IndividualPersonCNPValidator  {
    private String cnp;

    public IndividualPersonCNPValidator(String cnp) {
        this.cnp = cnp;
    }


    public void validate() throws FormValidationException {
        if (cnp == null) {
            throw new FormValidationException("Error ! You must add the CNP !");

        }
        if (cnp.length() != 13) {
            throw new FormValidationException("Error ! The CNP does not have the right number of digits !");

        }
        if (!cnp.matches("[0-9]+")) {
            throw new FormValidationException("Error ! The CNP-ul must contain only digits !");

        }
    }
}
