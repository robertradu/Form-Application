package com.primarie.tests.individualPersonValidators;

import com.primarie.service.FormValidationException;
import com.primarie.service.validators.individualPerson.IndividualPersonFirstNameValidator;
import org.junit.Test;

import static org.junit.Assert.fail;

public class IndividualPersonFirstNameValidatorTest {
    IndividualPersonFirstNameValidator individualPersonFirstNameValidator;


    @Test(expected = FormValidationException.class)
    public void testValidationFirstName() throws FormValidationException {
        String prenume = null;
        individualPersonFirstNameValidator = new IndividualPersonFirstNameValidator(prenume);
        individualPersonFirstNameValidator.validate();

    }

    @Test(expected = FormValidationException.class)
    public void testValidationFirstNameLength() throws FormValidationException {
        String prenume = "gternwgiuntreigniertunihunertihunerthrtehtttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt";
        individualPersonFirstNameValidator = new IndividualPersonFirstNameValidator(prenume);
        individualPersonFirstNameValidator.validate();

    }
}
