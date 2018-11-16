package ro.uti.robert.repository;

import ro.uti.robert.model.PoliceFormDB;

public interface PoliceFormRepository {
    /**
     * Creates or updates an entity of type {@link PoliceFormDB}.
     *
     * @param policeFormDB
     * @return: return the ID for created entity
     */
    PoliceFormDB savePoliceForm(PoliceFormDB policeFormDB);

    /**
     * Searches the id of the specified record of type {@link PoliceFormDB} exists
     *
     * @param policeFormDB
     * @return
     */
    Integer getPoliceFormId(PoliceFormDB policeFormDB);

    /**
     * Searches the specified record of type {@link PoliceFormDB}
     * @param id
     * @return
     */
    PoliceFormDB getPoliceForm(int id);

    /**
     * Counts all entities {@link PoliceFormDB} existent in DB
     * @return
     */
    Long countPoliceForms();

  //  void deletePoliceForm(int id);

}
