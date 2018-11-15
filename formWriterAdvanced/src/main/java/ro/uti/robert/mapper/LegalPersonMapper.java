package ro.uti.robert.mapper;

import com.primarie.model.LegalPerson;
import ro.uti.robert.model.LegalPersonDB;

public class LegalPersonMapper {
    private LegalPersonDB legalPersonDB;
    private LegalPerson legalPerson;

    public LegalPersonMapper() {
        legalPersonDB = new LegalPersonDB();
        legalPerson = new LegalPerson();
    }

    public LegalPersonDB toLegalPersonDB(LegalPerson legalPerson) {
        if (legalPerson != null) {
            legalPersonDB.setName(legalPerson.getName());
            legalPersonDB.setCif(legalPerson.getCif());
        }
        return legalPersonDB;
    }

    public LegalPerson toLegalPerson(LegalPersonDB legalPersonDB) {
        legalPerson.setName(legalPersonDB.getName());
        legalPerson.setCif(legalPersonDB.getCif());
        return legalPerson;
    }

}
