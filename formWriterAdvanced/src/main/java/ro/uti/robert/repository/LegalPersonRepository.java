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

    /**
     * Searches the id of the specified record of type{@link LegalPersonDB} exists
     *
     * @param legalPersonDB
     * @return
     */
    Integer getLegalPersonId(LegalPersonDB legalPersonDB);

    /**
     * Searches the specified record of type {@link LegalPersonDB}
     * @param id
     * @return
     */
    LegalPersonDB getLegalPerson(int id);

    /**
     * Counts all entities {@link LegalPersonDB} existent in DB
     * @return
     */
    Long countLegalPersons();
    //  boolean checkForExistence(LegalPersonDB legalPersonDB);

    //void deleteLegalPerson(int id);
}
