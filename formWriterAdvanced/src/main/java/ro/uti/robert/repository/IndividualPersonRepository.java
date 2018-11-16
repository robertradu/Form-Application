package ro.uti.robert.repository;

import ro.uti.robert.model.IndividualPersonDB;

public interface IndividualPersonRepository {
    /**
     * Creates or updates an entity of type {@link IndividualPersonDB}.
     *
     * @param individualPersonDB
     * @return: return the ID for created entity
     */
    IndividualPersonDB saveIndividualPerson(IndividualPersonDB individualPersonDB);

    /**
     * Searches the id of the specified record of type {@link IndividualPersonDB} exists
     *
     * @param individualPersonDB
     * @return
     */
    Integer getIndividualPersonId(IndividualPersonDB individualPersonDB);

    //   boolean checkForExistence(IndividualPersonDB individualPersonDB);

    /**
     * Searches the specified record of type {@link IndividualPersonDB}
     * @param id
     * @return
     */
    IndividualPersonDB getIndividualPerson(int id);

    /**
     * Counts all entities {@link IndividualPersonDB} existent in DB
     * @return
     */
    Long countIndividualPersons();

    //  void deleteIndividualPerson(Long id);

    // Long countIndividualPersons();
}
