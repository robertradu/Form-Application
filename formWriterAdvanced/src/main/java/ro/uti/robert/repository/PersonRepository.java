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

   // boolean checkForExistence(PersonDB personDB);

 //   void deletePerson(int id);
}
