package ro.uti.robert.repository.impl;

import com.primarie.model.Form;
import ro.uti.robert.Writer;
import ro.uti.robert.model.CoordinatesDB;
import ro.uti.robert.repository.CoordinatesRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CoordinatesDBRepository implements CoordinatesRepository {
    private CoordinatesDB coordinatesDB;
    private Form form;


    public void setUp() {
        Writer.connect();
    }

    public CoordinatesDBRepository() {
        setUp();
    }

    @Override
    public CoordinatesDB saveCoordinates(CoordinatesDB coordinatesDB) {
        try {
            PreparedStatement preparedStatement = Writer.connection.prepareStatement(
                    "INSERT INTO validated_forms.coordinates (latitude, longitude, altitude) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setDouble(1, coordinatesDB.getLatitude());
            preparedStatement.setDouble(2, coordinatesDB.getLongitude());
            preparedStatement.setDouble(3, coordinatesDB.getAltitude());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                coordinatesDB.setId(resultSet.getInt(1));
            }

            return coordinatesDB;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public boolean checkForExistence(CoordinatesDB coordinatesDB) {
        try {
            PreparedStatement preparedStatement = Writer.connection.prepareStatement(
                    "SELECT * FROM validated_forms.coordinates where latitude = " + coordinatesDB.getLatitude()
                            + " and longitude = " + coordinatesDB.getLongitude()
                            + " and altitude = " + coordinatesDB.getAltitude());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void deleteCoordinates(int id) {
        try {
            PreparedStatement preparedStatement = Writer.connection.prepareStatement("DELETE FROM validated_forms.coordinates WHERE id = " + id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public CoordinatesDB getCoordinatesDB() {
        return coordinatesDB;
    }

    public void setCoordinatesDB(CoordinatesDB coordinatesDB) {
        this.coordinatesDB = coordinatesDB;
    }

}
