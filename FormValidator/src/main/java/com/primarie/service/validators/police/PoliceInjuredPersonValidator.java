package com.primarie.service.validators.police;

import com.primarie.model.Person;
import com.primarie.service.FormValidationException;
import com.primarie.service.validators.FormValidator;

public class PoliceInjuredPersonValidator implements FormValidator {
    private Person person;

    public PoliceInjuredPersonValidator(Person person) {
        this.person = person;

    }

    @Override
    public void validate() throws FormValidationException {
        if (person != null) {
            if ((person.getLegalPerson() == null) && (person.getIndividualPerson() == null)) {
                throw new FormValidationException("Error ! The person you`ve added is not either an individual person or a legal person!");

            }
        }
    }
}
