package com.primarie.service.validators.police;

import com.primarie.model.PoliceForm;
import com.primarie.service.FormValidationException;
import com.primarie.service.validators.FormValidator;

public class PoliceFormValidator implements FormValidator {
    private PoliceForm policeForm;
    private PoliceAgentValidator policeAgentValidator;
    private PoliceApplicantValidator policeApplicantValidator;
    private PoliceAuthorizationNrValidator policeAuthorizationNrValidator;
    private PoliceDetailsValidator policeDetailsValidator;
    private PoliceLocationValidator policeLocationValidator;
    private PoliceInjuredPersonValidator policeInjuredPersonValidator;
    private PoliceRegistrationDateValidator policeRegistrationDateValidator;

    public PoliceFormValidator(PoliceForm policeForm) throws FormValidationException {
        this.policeForm = policeForm;
        policeAgentValidator = new PoliceAgentValidator(policeForm.getAgent());
        policeApplicantValidator = new PoliceApplicantValidator(policeForm.getApplicant());
        policeAuthorizationNrValidator = new PoliceAuthorizationNrValidator(policeForm.getAuthorizationNr());
        policeDetailsValidator = new PoliceDetailsValidator(policeForm.getDetails());
        policeLocationValidator = new PoliceLocationValidator(policeForm.getLocation());
        policeInjuredPersonValidator = new PoliceInjuredPersonValidator(policeForm.getPerson());
        policeRegistrationDateValidator = new PoliceRegistrationDateValidator(policeForm.getRecordDate());

        // new IndividualPersonFormValidator(policeForm.applicant);
        validate();
    }

    @Override
    public void validate() throws FormValidationException {
        policeAgentValidator.validate();
        policeApplicantValidator.validate();
        policeAuthorizationNrValidator.validate();
        policeDetailsValidator.validate();
        policeLocationValidator.validate();
        policeInjuredPersonValidator.validate();
        policeRegistrationDateValidator.validate();

    }
}
