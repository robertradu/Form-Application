package ro.uti.robert.repository;

import ro.uti.robert.model.AddressDB;
import ro.uti.robert.model.IndividualPersonDB;
import ro.uti.robert.model.LegalPersonDB;
import ro.uti.robert.model.PersonDB;

public interface PersonRepository {
    PersonDB savePerson(PersonDB personDB);

    boolean checkForExistence(PersonDB personDB);

    void deletePerson(int id);
}
