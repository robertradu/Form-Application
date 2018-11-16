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

    /**
     * Searches the id of the specified record of type {@link InjuredPersonDB} exists
     *
     * @param injuredPersonDB
     * @return
     */
    Integer getInjuredPersonId(InjuredPersonDB injuredPersonDB);

    /**
     * Searches the specified record of type {@link InjuredPersonDB}
     *
     * @param id
     * @return
     */
    InjuredPersonDB getInjuredPerson(int id);

    /**
     * Counts all entities {@link InjuredPersonDB} existent in DB
     * @return
     */
    Long countInjuredPersons();
    // boolean checkForExistence(InjuredPersonDB injuredPersonDB);

    //  void deleteInjuredPerson(int id);
}
