package com.primarie.service.validators.police;

import com.primarie.model.Person;
import com.primarie.service.FormValidationException;
import com.primarie.service.validators.FormValidator;

public class PoliceAgentValidator implements FormValidator {
    private Person agent;

    public PoliceAgentValidator(Person agent) {
        this.agent = agent;
    }

    @Override
    public void validate() throws FormValidationException {
        if (agent != null) {
            if (agent.getIndividualPerson() == null)
                throw new FormValidationException("Error ! The person you`ve added is not a legal person !");
        }
    }
}
