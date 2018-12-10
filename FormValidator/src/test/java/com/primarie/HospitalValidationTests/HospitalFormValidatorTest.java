package com.primarie.HospitalValidationTests;

import com.primarie.model.HospitalForm;
import com.primarie.service.FormValidationException;
import com.primarie.service.validators.hospital.HospitalAuthorizationNrValidator;
import com.primarie.service.validators.hospital.HospitalFormValidator;
import org.junit.Test;

public class HospitalFormValidatorTest {
    HospitalAuthorizationNrValidator hospitalAuthorizationNrValidator;

    @Test(expected = FormValidationException.class)
    public void testValidation() throws FormValidationException {
        HospitalFormValidator hospitalFormValidator = new HospitalFormValidator(new HospitalForm());

        // Apelarea validarii
        hospitalFormValidator.validate();
    }

}
