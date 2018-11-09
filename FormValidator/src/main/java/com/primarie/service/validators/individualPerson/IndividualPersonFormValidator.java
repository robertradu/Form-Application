package com.primarie.service.validators.individualPerson;

import com.primarie.model.IndividualPerson;
import com.primarie.service.FormValidationException;

public class IndividualPersonFormValidator {
    private IndividualPerson individualPerson;
    private IndividualPersonCitizenshipValidator individualPersonCitizenshipValidator;
    private IndividualPersonCNPValidator individualPersonCNPValidator;
    private IndividualPersonFirstNameValidator individualPersonFirstNameValidator;
    private IndividualPersonLastNameValidator individualPersonLastNameValidator;


    public IndividualPersonFormValidator(IndividualPerson individualPerson) throws FormValidationException {
        this.individualPerson = individualPerson;
        individualPersonCitizenshipValidator = new IndividualPersonCitizenshipValidator(individualPerson.getCitizenship());
        individualPersonCNPValidator = new IndividualPersonCNPValidator(individualPerson.getCnp());
        individualPersonFirstNameValidator = new IndividualPersonFirstNameValidator(individualPerson.getFirstName());
        individualPersonLastNameValidator = new IndividualPersonLastNameValidator(individualPerson.getLastName());
        validate();
    }


    public void validate() throws FormValidationException {
        individualPersonCitizenshipValidator.validate();
        individualPersonCNPValidator.validate();
        individualPersonFirstNameValidator.validate();
        individualPersonLastNameValidator.validate();
    }
}
