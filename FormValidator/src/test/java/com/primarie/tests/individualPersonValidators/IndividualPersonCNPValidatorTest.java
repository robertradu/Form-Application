package com.primarie.tests.individualPersonValidators;

import com.primarie.service.FormValidationException;
import com.primarie.service.validators.individualPerson.IndividualPersonCNPValidator;
import org.junit.Test;

import static org.junit.Assert.fail;

public class IndividualPersonCNPValidatorTest {

    public IndividualPersonCNPValidator individualPersonCNPValidator;


    @Test(expected = FormValidationException.class)
    public void testValidationCNP() throws FormValidationException {
        String cnp = null;
        individualPersonCNPValidator = new IndividualPersonCNPValidator(cnp);
        individualPersonCNPValidator.validate();

    }


    @Test(expected = FormValidationException.class)
    public void testValidationCNPLength() throws FormValidationException {
        String cnp = "134";
        individualPersonCNPValidator = new IndividualPersonCNPValidator(cnp);
        individualPersonCNPValidator.validate();

    }

    @Test(expected = FormValidationException.class)
    public void testValidationCNPCharacters() throws FormValidationException {
        String cnp = "ADG1234567891";
        individualPersonCNPValidator = new IndividualPersonCNPValidator(cnp);
        individualPersonCNPValidator.validate();

    }
}



