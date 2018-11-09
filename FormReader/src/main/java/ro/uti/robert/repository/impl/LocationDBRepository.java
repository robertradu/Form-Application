package ro.uti.robert.repository.impl;

import ro.uti.robert.Writer;
import ro.uti.robert.model.AddressDB;
import ro.uti.robert.model.CoordinatesDB;
import ro.uti.robert.model.LocationDB;
import ro.uti.robert.repository.LocationRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LocationDBRepository implements LocationRepository {
    private LocationDB locationDB;

    public void setUp() {
        Writer.connect();
    }

    public LocationDBRepository() {
        setUp();
    }

    @Override
    public LocationDB saveLocation(LocationDB locationDB, AddressDB addressDB, CoordinatesDB coordinatesDB) {
        try {
            PreparedStatement preparedStatement = Writer.connection.prepareStatement("INSERT INTO validated_forms.location (description, coordinates_id, address_id) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, locationDB.getDescription());
            preparedStatement.setInt(2, coordinatesDB.getId());
            preparedStatement.setInt(3, addressDB.getId());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                locationDB.setId(resultSet.getInt(1));
            }
            return locationDB;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean checkForExistence(LocationDB locationDB) {
        try {
            PreparedStatement preparedStatement = Writer.connection.prepareStatement(
                    "SELECT * FROM validated_forms.location where description = '" + locationDB.getDescription() + "'"
                            + " and coordinates_id = " + locationDB.getCoordinatesId()
                            + " and address_id = " + locationDB.getAddressId());

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

    public LocationDB getLocationDB() {
        return locationDB;
    }

    public void setLocationDB(LocationDB locationDB) {
        this.locationDB = locationDB;
    }

    @Override
    public void deleteLocation(int id) {

    }
}
