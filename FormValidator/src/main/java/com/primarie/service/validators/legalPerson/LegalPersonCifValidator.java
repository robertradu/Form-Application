package com.primarie.service.validators.legalPerson;

import com.primarie.service.FormValidationException;

public class LegalPersonCifValidator{
    private String cif;

    public LegalPersonCifValidator(String cif) {
        this.cif = cif;

    }


    public void validate() throws FormValidationException {
        if (cif == null) {
            throw new FormValidationException("Error ! You must add the cif !");
        }

        if (cif.length() < 2)
            throw new FormValidationException("Error ! The length of the cif is too small");

        if (cif.length() > 20)
            throw new FormValidationException("Eroare! You`ve exceeded the length of the cif");

        if (!cif.matches("[0-9]+"))
            throw new FormValidationException("Error ! The cif-ul must contain at least one digit !");
    }
}