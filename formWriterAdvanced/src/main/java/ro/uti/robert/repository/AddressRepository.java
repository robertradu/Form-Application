package ro.uti.robert.repository;

import ro.uti.robert.model.AddressDB;

public interface AddressRepository {
    /**
     * Creates or updates an entity of type {@link AddressDB}.
     *
     * @param addressDB
     * @return: return the ID for created entity
     */
    AddressDB saveAddress(AddressDB addressDB);

 //   boolean checkForExistence(AddressDB addressDB);

  //  void deleteAddress(int id);

}
