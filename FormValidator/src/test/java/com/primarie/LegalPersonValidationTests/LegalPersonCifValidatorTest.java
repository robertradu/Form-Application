package com.primarie.LegalPersonValidationTests;

import com.primarie.service.FormValidationException;
import com.primarie.service.validators.legalPerson.LegalPersonCifValidator;
import org.junit.Test;

import static org.junit.Assert.fail;

public class LegalPersonCifValidatorTest {
    LegalPersonCifValidator legalPersonCifValidator;

    @Test(expected = FormValidationException.class)
    public void testValidationCif() throws FormValidationException {
        String cif = null;
        legalPersonCifValidator = new LegalPersonCifValidator(cif);
        legalPersonCifValidator.validate();


    }

    @Test(expected = FormValidationException.class)
    public void testValidationCifSmallerLength() throws FormValidationException {
        String cif = "1";
        legalPersonCifValidator = new LegalPersonCifValidator(cif);
        legalPersonCifValidator.validate();

    }

    @Test(expected = FormValidationException.class)
    public void testValidationCifBiggerLength() throws FormValidationException {
        String cif = "432423423423423rwerwerweeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
        legalPersonCifValidator = new LegalPersonCifValidator(cif);
        legalPersonCifValidator.validate();

    }

    @Test(expected = FormValidationException.class)
    public void testValidationCifContains() throws FormValidationException {
        String cif = "abdf";
        legalPersonCifValidator = new LegalPersonCifValidator(cif);
        legalPersonCifValidator.validate();

    }
}
