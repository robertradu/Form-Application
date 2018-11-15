package ro.uti.robert.repository;

import ro.uti.robert.model.PoliceFormDB;

public interface PoliceFormRepository {
    PoliceFormDB savePoliceForm(PoliceFormDB policeFormDB);

    void deletePoliceForm(int id);

}
