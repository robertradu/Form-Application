package ro.uti.robert.repository;

import ro.uti.robert.model.PersonDB;

public interface PersonRepository {
    /**
     * Creates or updates an entity of type {@link PersonDB}.
     *
     * @param personDB
     * @return: return the ID for created entity
     */
    PersonDB savePerson(PersonDB personDB);

    /**
     * Searches the id of the specified record of type {@link PersonDB} exists
     *
     * @param personDB
     * @return
     */
    Integer getPersonId(PersonDB personDB);

    /**
     * Searches the specified record of type {@link PersonDB}
     *
     * @param id
     * @return
     */
    PersonDB getPerson(int id);

    /**
     * Counts all entities {@link PersonDB} existent in DB
     * @return
     */
    Long countPersons();
    // boolean checkForExistence(PersonDB personDB);

    //   void deletePerson(int id);
}
