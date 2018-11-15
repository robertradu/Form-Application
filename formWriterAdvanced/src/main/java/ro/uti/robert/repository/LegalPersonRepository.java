package ro.uti.robert.repository;

import ro.uti.robert.model.LegalPersonDB;

public interface LegalPersonRepository {
    /**
     * Creates or updates an entity of type {@link LegalPersonDB}.
     *
     * @param legalPersonDB
     * @return: return the ID for created entity
     */
    LegalPersonDB saveLegalPerson(LegalPersonDB legalPersonDB);

  //  boolean checkForExistence(LegalPersonDB legalPersonDB);

    //void deleteLegalPerson(int id);
}
