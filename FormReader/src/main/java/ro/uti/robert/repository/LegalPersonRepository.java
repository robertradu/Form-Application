package ro.uti.robert.repository;

import ro.uti.robert.model.LegalPersonDB;

public interface LegalPersonRepository {
    LegalPersonDB saveLegalPerson(LegalPersonDB legalPersonDB);

    boolean checkForExistence(LegalPersonDB legalPersonDB);

    void deleteLegalPerson(int id);
}
