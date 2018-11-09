package com.primarie.service.validators.person;

import com.primarie.model.Person;
import com.primarie.service.FormValidationException;
import com.primarie.service.validators.FormValidator;
import com.primarie.service.validators.individualPerson.*;
import com.primarie.service.validators.legalPerson.LegalPersonFormValidator;

public class PersonValidator implements FormValidator {

    private Person person;
    private IndividualPersonFormValidator individualPersonFormValidator;
    private LegalPersonFormValidator legalPersonFormValidator;
    private AddressValidator addressValidator;
    private TelephoneValidator telephoneValidator;

    public PersonValidator(Person person) throws FormValidationException {
        this.person = person;
        if (person.getLegalPerson() == null)
            individualPersonFormValidator = new IndividualPersonFormValidator(person.getIndividualPerson());
        if (person.getIndividualPerson() == null)
            legalPersonFormValidator = new LegalPersonFormValidator(person.getLegalPerson());
        addressValidator = new AddressValidator(person.getAddress());
        telephoneValidator = new TelephoneValidator(person.getTelephone());
        validate();
    }

    @Override
    public void validate() throws FormValidationException {
        if (person.getLegalPerson() == null)
            individualPersonFormValidator.validate();
        if (person.getIndividualPerson() == null)
            legalPersonFormValidator.validate();
        addressValidator.validate();
        telephoneValidator.validate();

    }
}
