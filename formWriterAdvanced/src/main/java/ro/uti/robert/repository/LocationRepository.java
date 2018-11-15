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

   // boolean checkForExistence(LocationDB locationDB);

    //void deleteLocation(int id);

}
