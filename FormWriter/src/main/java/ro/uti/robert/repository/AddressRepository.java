package ro.uti.robert.repository;

import ro.uti.robert.model.AddressDB;

public interface AddressRepository {
    AddressDB saveAddress(AddressDB addressDB);

    boolean checkForExistence(AddressDB addressDB);

    void deleteAddress(int id);

}
