package ro.uti.robert.repository;

import ro.uti.robert.model.CoordinatesDB;

public interface CoordinatesRepository {
    /**
     * Creates or updates an entity of type {@link CoordinatesDB}.
     *
     * @param coordinatesDB
     * @return: return the ID for created entity
     */
    CoordinatesDB saveCoordinates(CoordinatesDB coordinatesDB);



   // void deleteCoordinates(int id);
}
