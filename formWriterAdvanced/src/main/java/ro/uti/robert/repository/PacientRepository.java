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

    /**
     * Searches the id of the specified record of type {@link PacientDB} exists
     * @param pacientDB
     * @return
     */
    Integer getPacientId(PacientDB pacientDB);

    /**
     * Searches the specified record of type {@link PacientDB}
     * @param id
     * @return
     */
    PacientDB getPacient(int id);

    /**
     * Counts all entities {@link PacientDB} existent in DB
     * @return
     */
    Long countPacients();

    // boolean checkForExistence(PacientDB pacientDB);

    //  void deletePacientDB(int id);
}
