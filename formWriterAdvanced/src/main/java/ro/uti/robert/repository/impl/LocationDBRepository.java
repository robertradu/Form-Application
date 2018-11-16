package ro.uti.robert.repository.impl;

import org.hibernate.query.Query;
import ro.uti.robert.AdvancedWriter;
import ro.uti.robert.model.AddressDB;
import ro.uti.robert.model.CoordinatesDB;
import ro.uti.robert.model.LocationDB;
import ro.uti.robert.repository.LocationRepository;

import javax.swing.*;

public class LocationDBRepository implements LocationRepository {

    public LocationDBRepository() {

    }

    @Override
    public LocationDB saveLocation(LocationDB locationDB, AddressDB addressDB, CoordinatesDB coordinatesDB) {
        Integer id = getLocationId(locationDB, addressDB, coordinatesDB);
        if (id == null) {
            AdvancedWriter.getSession().save(locationDB);
        } else {
            locationDB.setId(id);
        }

        return locationDB;


    }

    @Override
    public Integer getLocationId(LocationDB locationDB, AddressDB addressDB, CoordinatesDB coordinatesDB) {
        Query query = AdvancedWriter.getSession().createQuery("select id from LocationDB " +
                " where description = '" + locationDB.getDescription() + "'"
                + " and coordinatesId = " + coordinatesDB.getId()
                + " and addressId = " + addressDB.getId()
        );

        Integer id = (Integer) query.uniqueResult();
        return id;
    }

    @Override
    public LocationDB getLocation(int id) {
        LocationDB locationDB = AdvancedWriter.getSession().get(LocationDB.class, id);

        if (locationDB != null) {
            return locationDB;
        }
        JOptionPane.showMessageDialog(null, "No record with id = : " + id);
        return null;
    }

    @Override
    public Long countLocations() {
        Query query = AdvancedWriter.getSession().createQuery("select count(id) from LocationDB");

        Long id = (Long) query.uniqueResult();
        return id;    }

   /* @Override
    public boolean checkForExistence(LocationDB locationDB) {
        try {
            PreparedStatement preparedStatement = AdvancedWriter.getConnection().prepareStatement(
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

    }*/
}
