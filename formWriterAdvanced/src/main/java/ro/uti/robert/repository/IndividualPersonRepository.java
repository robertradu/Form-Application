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

 //   boolean checkForExistence(IndividualPersonDB individualPersonDB);

  //  IndividualPersonDB getIndividualPerson(Long id);

  //  void deleteIndividualPerson(Long id);

   // Long countIndividualPersons();
}
