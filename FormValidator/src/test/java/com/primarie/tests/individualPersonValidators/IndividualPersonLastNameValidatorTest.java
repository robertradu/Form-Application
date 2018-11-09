package com.primarie.tests.individualPersonValidators;

import com.primarie.service.FormValidationException;
import com.primarie.service.validators.individualPerson.IndividualPersonLastNameValidator;
import org.junit.Test;

import static org.junit.Assert.fail;

public class IndividualPersonLastNameValidatorTest {
    IndividualPersonLastNameValidator individualPersonLastNameValidator;

    @Test(expected = FormValidationException.class)
    public void testValidationName() throws FormValidationException {
        String nume = null;
        individualPersonLastNameValidator = new IndividualPersonLastNameValidator(nume);
        individualPersonLastNameValidator.validate();

    }

    @Test(expected = FormValidationException.class)
    public void testValidationNameLength() throws FormValidationException {
        String nume = "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhggggggggggggggggggggggggggggggggggggggggggggggggfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff";
        individualPersonLastNameValidator = new IndividualPersonLastNameValidator(nume);
        individualPersonLastNameValidator.validate();

    }

}
