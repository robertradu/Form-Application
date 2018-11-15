package ro.uti.robert.mapper;

import com.primarie.model.Person;
import ro.uti.robert.model.InjuredPersonDB;
import ro.uti.robert.model.PersonDB;

public class InjuredPersonMapper {
    private InjuredPersonDB injuredPersonDB;
    private PersonDB personDB;

    public InjuredPersonMapper() {
        injuredPersonDB = new InjuredPersonDB();
        personDB = new PersonDB();
    }

    public InjuredPersonDB toInjuredPersonDB(PersonDB personDB) {
        injuredPersonDB.setPersonId(personDB.getId());
        return injuredPersonDB;
    }

}
