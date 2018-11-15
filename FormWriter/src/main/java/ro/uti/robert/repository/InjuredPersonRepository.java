package ro.uti.robert.repository;

import ro.uti.robert.model.InjuredPersonDB;

public interface InjuredPersonRepository {
    InjuredPersonDB saveInjuredPerson(InjuredPersonDB injuredPersonDB);

    boolean checkForExistence(InjuredPersonDB injuredPersonDB);

    void deleteInjuredPerson(int id);
}
