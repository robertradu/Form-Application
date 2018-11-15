package ro.uti.robert.mapper;

import ro.uti.robert.model.PacientDB;
import ro.uti.robert.model.PersonDB;

public class PacientMapper {
    private PacientDB pacientDB;
    private PersonDB personDB;

    public PacientMapper() {
        pacientDB = new PacientDB();
        personDB = new PersonDB();
    }

    public PacientDB toPacientDB(PersonDB personDB) {
        pacientDB.setIndividualPersonId(personDB.getIndividualPersonId());
        return pacientDB;
    }
}
