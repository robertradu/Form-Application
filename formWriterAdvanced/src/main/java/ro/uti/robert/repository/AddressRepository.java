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

    /**
     * Searches the id of the specified record of type {@link AddressDB} exists
     *
     * @param addressDB
     * @return
     */
    Integer getAddressId(AddressDB addressDB);

    /**
     * Searches the specified record of type {@link AddressDB}
     *
     * @param id
     * @return
     */
    AddressDB getAddress(int id);

    /**
     * Counts all entities {@link AddressDB} existent in DB
     *
     * @return
     */
    Long countAddresses();

    //   boolean checkForExistence(AddressDB addressDB);

    //  void deleteAddress(int id);

}
