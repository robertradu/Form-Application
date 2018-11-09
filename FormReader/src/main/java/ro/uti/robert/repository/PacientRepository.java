package ro.uti.robert.repository;

import ro.uti.robert.model.PacientDB;

public interface PacientRepository {
    PacientDB savePacientDB(PacientDB pacientDB);

    boolean checkForExistence(PacientDB pacientDB);

    void deletePacientDB(int id);
}
