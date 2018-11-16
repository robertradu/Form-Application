package ro.uti.robert.repository;

import ro.uti.robert.model.AddressDB;
import ro.uti.robert.model.CoordinatesDB;
import ro.uti.robert.model.LocationDB;

public interface LocationRepository {
    /**
     * Creates or updates an entity of type {@link LocationDB}.
     *
     * @param locationDB, addressDB, coordinatesDB
     * @return: return the ID for created entity
     */
    LocationDB saveLocation(LocationDB locationDB, AddressDB addressDB, CoordinatesDB coordinatesDB);

    /**
     * Searches the id of the specified record of type{@link LocationDB} exists
     *
     * @param locationDB
     * @return
     */
    Integer getLocationId(LocationDB locationDB, AddressDB addressDB, CoordinatesDB coordinatesDB);


    /**
     * Searches the specified record of type {@link LocationDB}
     * @param id
     * @return
     */
    LocationDB getLocation(int id);

    /**
     * Counts all entities {@link LocationDB} existent in DB
     * @return
     */
    Long countLocations();

    // boolean checkForExistence(LocationDB locationDB);

    //void deleteLocation(int id);

}
