package ro.uti.robert.repository;

import ro.uti.robert.model.CoordinatesDB;

public interface CoordinatesRepository {

    CoordinatesDB saveCoordinates(CoordinatesDB coordinatesDB);

    boolean checkForExistence(CoordinatesDB coordinatesDB);

    void deleteCoordinates(int id);
}
