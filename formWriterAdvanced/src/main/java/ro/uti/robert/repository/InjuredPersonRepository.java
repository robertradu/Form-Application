package ro.uti.robert.repository;

import ro.uti.robert.model.InjuredPersonDB;

public interface InjuredPersonRepository {
    /**
     * Creates or updates an entity of type {@link InjuredPersonDB}.
     *
     * @param injuredPersonDB
     * @return: return the ID for created entity
     */
    InjuredPersonDB saveInjuredPerson(InjuredPersonDB injuredPersonDB);

   // boolean checkForExistence(InjuredPersonDB injuredPersonDB);

  //  void deleteInjuredPerson(int id);
}
