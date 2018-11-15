package ro.uti.robert.mapper;

import com.primarie.model.Coordinates;
import com.primarie.model.Form;
import ro.uti.robert.model.CoordinatesDB;

public class CoordinatesMapper {
    private CoordinatesDB coordinatesDB;
    private Coordinates coordinates;

    public CoordinatesMapper(){
        coordinatesDB = new CoordinatesDB();
        coordinates = new Coordinates();
    }

    public CoordinatesDB toCoordinatesDB(Coordinates coordinates) {
        coordinatesDB.setAltitude(coordinates.getAltitude());
        coordinatesDB.setLatitude(coordinates.getLatitude());
        coordinatesDB.setLongitude(coordinates.getLongitude());
        return coordinatesDB;
    }

    public Coordinates toCoordinates(CoordinatesDB coordinatesDB) {
        coordinates.setAltitude(coordinatesDB.getAltitude());
        coordinates.setLatitude(coordinatesDB.getLatitude());
        coordinates.setLongitude(coordinatesDB.getLongitude());
        return coordinates;
    }
}
