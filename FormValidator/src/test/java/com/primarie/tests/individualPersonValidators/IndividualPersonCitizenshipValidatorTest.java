package com.primarie.tests.individualPersonValidators;

import com.primarie.service.FormValidationException;
import com.primarie.service.validators.individualPerson.IndividualPersonCitizenshipValidator;
import org.junit.Test;

public class IndividualPersonCitizenshipValidatorTest {

    public IndividualPersonCitizenshipValidator individualPersonCitizenshipValidator;


    @Test(expected = FormValidationException.class)
    public void testValidationCitizenship() throws FormValidationException {
        String cetatenie = null;
        individualPersonCitizenshipValidator = new IndividualPersonCitizenshipValidator(cetatenie);
        individualPersonCitizenshipValidator.validate();

    }

}
