package com.primarie.service.validators.company;

import com.primarie.model.CompanyForm;
import com.primarie.service.FormValidationException;
import com.primarie.service.validators.FormValidator;

public class CompanyFormValidator implements FormValidator {
    private CompanyForm companyForm;
    private CompanyApplicantValidator companyApplicantValidator;
    private CompanyContractNrValidator companyContractNrValidator;
    private CompanyDetailsValidator companyDetailsValidator;
    private CompanyLocationValidator companyLocationValidator;
    private CompanyRegistrationDateValidator companyRegistrationDateValidator;

    public CompanyFormValidator(CompanyForm companyForm) throws FormValidationException {
        this.companyForm = companyForm;
        companyApplicantValidator = new CompanyApplicantValidator(companyForm.getApplicant());
        companyContractNrValidator = new CompanyContractNrValidator(companyForm.getContractNr());
        companyDetailsValidator = new CompanyDetailsValidator(companyForm.getDetails());
        companyLocationValidator = new CompanyLocationValidator(companyForm.getLocation());
        companyRegistrationDateValidator = new CompanyRegistrationDateValidator(companyForm.getRecordDate());
        validate();
    }

    @Override
    public void validate() throws FormValidationException {
        companyApplicantValidator.validate();
        companyContractNrValidator.validate();
        companyDetailsValidator.validate();
        companyLocationValidator.validate();
        companyRegistrationDateValidator.validate();
    }
}
