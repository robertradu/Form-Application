package com.primarie.HospitalValidationTests;

import com.primarie.model.IndividualPerson;
import com.primarie.model.Human;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.fail;

public class HospitalPacientValidatorTest {
    @Test
    public void testValidationPacient() {
        Human o = new Human();
        boolean exceptionFound = false;
        try {
            Assert.assertThat(o, instanceOf(IndividualPerson.class));
        } catch (AssertionError e) {
            exceptionFound = true;
        }
        if (exceptionFound == false) {
            fail("Exception should be thrown!");
        }
    }
}
