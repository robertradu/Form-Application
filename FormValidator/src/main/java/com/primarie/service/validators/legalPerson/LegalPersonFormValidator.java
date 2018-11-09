package com.primarie.service.validators.legalPerson;

import com.primarie.model.LegalPerson;
import com.primarie.service.FormValidationException;

public class LegalPersonFormValidator {
    private LegalPerson legalPerson;
    private LegalPersonCifValidator legalPersonCifValidator;
    private LegalPersonNameValidator legalPersonNameValidator;

    public LegalPersonFormValidator(LegalPerson legalPerson) throws FormValidationException {
        this.legalPerson = legalPerson;
        legalPersonCifValidator = new LegalPersonCifValidator(legalPerson.getCif());
        legalPersonNameValidator = new LegalPersonNameValidator(legalPerson.getName());
        validate();
    }


    public void validate() throws FormValidationException {
        legalPersonCifValidator.validate();
        legalPersonNameValidator.validate();
    }
}
