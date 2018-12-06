package com.primarie.service.validators.hospital;

import com.primarie.model.HospitalForm;
import com.primarie.service.FormValidationException;
import com.primarie.service.validators.FormValidator;

public class HospitalFormValidator implements FormValidator {

    private HospitalForm hospitalForm;

    private HospitalDetailsValidator hospitalDetailsValidator;
    private HospitalEquipmentValidator hospitalEquipmentValidator;
    private HospitalLocationValidator hospitalLocationValidator;
    private HospitalApplicantValidator hospitalApplicantValidator;
    private HospitalAuthorizationNrValidator hospitalAuthorizationNrValidator;
    private HospitalRegistrationDateValidator hospitalRegistrationDateValidator;

    public HospitalFormValidator(HospitalForm hospitalForm) throws  FormValidationException{
        this.hospitalForm = hospitalForm;
        hospitalDetailsValidator = new HospitalDetailsValidator(hospitalForm.getDetails());
        hospitalEquipmentValidator = new HospitalEquipmentValidator(hospitalForm.getEquipment());
        hospitalLocationValidator = new HospitalLocationValidator(hospitalForm.getLocation());
        hospitalApplicantValidator = new HospitalApplicantValidator(hospitalForm.getApplicant());
        hospitalAuthorizationNrValidator = new HospitalAuthorizationNrValidator(hospitalForm.getAuthorizationNr());
        hospitalRegistrationDateValidator = new HospitalRegistrationDateValidator(hospitalForm.getRecordDate());
        //TODO: e de evitat apelarea de functii sau logica in constructor
        validate();
    }

    @Override
    public void validate() throws FormValidationException {
        hospitalDetailsValidator.validate();
        hospitalEquipmentValidator.validate();
        hospitalLocationValidator.validate();
        hospitalApplicantValidator.validate();
        hospitalAuthorizationNrValidator.validate();
        hospitalRegistrationDateValidator.validate();
    }
}
