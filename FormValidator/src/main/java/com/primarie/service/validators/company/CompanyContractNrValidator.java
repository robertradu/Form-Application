package com.primarie.service.validators.company;

import com.primarie.service.FormValidationException;
import com.primarie.service.validators.FormValidator;

public class CompanyContractNrValidator implements FormValidator {
    private String contractNr;

    public CompanyContractNrValidator(String contractNr) {
        this.contractNr = contractNr;

    }

    @Override
    public void validate() throws FormValidationException {
        if (contractNr == null)
            throw new FormValidationException("Error ! You must add a contract number !");

        if ((contractNr.length() > 10))
            throw new FormValidationException("Error! You`ve exceeded the length of the contract number field !");


        if (!(contractNr.matches("[0-9]+")) | (contractNr.matches("[-/]"))) {
            throw new FormValidationException("Error ! Contract number must contain specified characters !");

        }
    }
}
