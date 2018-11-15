package ro.uti.robert.repository;

import ro.uti.robert.model.PacientDB;

public interface PacientRepository {
    /**
     * Creates or updates an entity of type {@link PacientDB}.
     *
     * @param pacientDB
     * @return: return the ID for created entity
     */
    PacientDB savePacientDB(PacientDB pacientDB);

   // boolean checkForExistence(PacientDB pacientDB);

  //  void deletePacientDB(int id);
}
