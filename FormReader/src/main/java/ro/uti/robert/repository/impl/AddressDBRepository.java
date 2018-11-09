package ro.uti.robert.repository.impl;

import ro.uti.robert.Writer;
import ro.uti.robert.model.AddressDB;
import ro.uti.robert.repository.AddressRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressDBRepository implements AddressRepository {
    private AddressDB addressDB;


    public void setUp() {
        Writer.connect();
    }

    public AddressDBRepository() {
        setUp();
    }

    @Override
    public AddressDB saveAddress(AddressDB addressDB) {
        try {
            PreparedStatement preparedStatement = Writer.connection.prepareStatement("INSERT INTO validated_forms.address (number, street, city, county, country, postalcode) values (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, addressDB.getNumber());
            preparedStatement.setString(2, addressDB.getStreet());
            preparedStatement.setString(3, addressDB.getCity());
            preparedStatement.setString(4, addressDB.getCounty());
            preparedStatement.setString(5, addressDB.getCountry());
            preparedStatement.setString(6, addressDB.getPostalCode());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                addressDB.setId(resultSet.getInt(1));
            }
            return addressDB;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean checkForExistence(AddressDB addressDB) {
        try {
            PreparedStatement preparedStatement = Writer.connection.prepareStatement(
                    "SELECT * FROM validated_forms.address where number = " + addressDB.getNumber()
                            + " and street = '" + addressDB.getStreet() + "' "
                            + " and city = '" + addressDB.getCity() + "'"
                            + " and county = '" + addressDB.getCounty() + "'"
                            + " and country = '" + addressDB.getCountry() + "'"
                            + " and postalcode = '" + addressDB.getPostalCode() + "'");

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
    public void deleteAddress(int id) {

    }

    public AddressDB getAddressDB() {
        return addressDB;
    }

    public void setAddressDB(AddressDB addressDB) {
        this.addressDB = addressDB;
    }
}
