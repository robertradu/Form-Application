package com.primarie.service.validators;

import com.primarie.model.*;
import com.primarie.service.FormValidationException;
import com.primarie.service.validators.company.CompanyFormValidator;
import com.primarie.service.validators.police.PoliceFormValidator;
import com.primarie.service.validators.hospital.HospitalFormValidator;

public class FormValidatorFactory {

    public FormValidator getValidator(Form form) throws FormValidationException {
        if (form == null)
            return null;

        if (form instanceof StateForm) {
            if (form instanceof HospitalForm) {
          //      System.out.println("Se creaza un formular tip spital");
                return new HospitalFormValidator((HospitalForm) form);
            }
            if (form instanceof PoliceForm) {
          //      System.out.println("Se creaza un formular tip politie");
                return new PoliceFormValidator((PoliceForm) form);
            }
        }
        if (form instanceof PrivateForm) {
            if (form instanceof CompanyForm) {
          //      System.out.println("Se creaza un formular tip firma");
                return new CompanyFormValidator((CompanyForm) form);
            }

        }
        throw new IllegalArgumentException("Formularul introdus nu este apartine niciunuia dintre cele 3 tipuri admise");

    }
}
