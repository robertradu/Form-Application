package ro.uti.robert.repository;

import ro.uti.robert.model.AddressDB;
import ro.uti.robert.model.IndividualPersonDB;

public interface IndividualPersonRepository {

    IndividualPersonDB saveIndividualPerson(IndividualPersonDB individualPersonDB);

    boolean checkForExistence(IndividualPersonDB individualPersonDB);

    IndividualPersonDB getIndividualPerson(Long id);

    void deleteIndividualPerson(Long id);

    Long countIndividualPersons();
}
