package com.primarie.service.validators.hospital;

import com.primarie.model.Person;
import com.primarie.service.FormValidationException;
import com.primarie.service.validators.FormValidator;

public class HospitalPacientValidator implements FormValidator {
    private Person person;

    public HospitalPacientValidator(Person person) throws FormValidationException {
        this.person = person;
    }

    @Override
    public void validate() throws FormValidationException {
        if (person != null) {
            if (person.getIndividualPerson() == null)
                throw new FormValidationException("Error ! The person you`ve added is not an individual person !");

        }
    }
}
