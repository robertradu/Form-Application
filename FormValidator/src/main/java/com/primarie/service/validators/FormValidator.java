package com.primarie.service.validators;

        import com.primarie.service.FormValidationException;

public interface FormValidator {

    /**
     * Validation method implemented by any validator.
     *
     * @throws FormValidationException: exception thrown if any constraint violation is detected
     */
    void validate() throws FormValidationException;
}
