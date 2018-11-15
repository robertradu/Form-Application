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

  //  void deletePoliceForm(int id);

}
