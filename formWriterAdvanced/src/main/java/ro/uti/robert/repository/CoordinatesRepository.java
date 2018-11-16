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

    /**
     * Searches the id of the specified record of type {@link CoordinatesDB} exists
     *
     * @param coordinatesDB
     * @return
     */
    Integer getCoordinatesId(CoordinatesDB coordinatesDB);

    /**
     * Searches the specified record of type {@link CoordinatesDB}
     *
     * @param id
     * @return
     */
    CoordinatesDB getCoordinates(int id);

    /**
     * Removes the specified record of type {@link CoordinatesDB}
     * @param id
     * @return
     */
    void deleteCoordinates(int id);

    /**
     * Counts all entities {@link CoordinatesDB} existent in DB
     *
     * @return
     */
    Long countCoordinates();
}
