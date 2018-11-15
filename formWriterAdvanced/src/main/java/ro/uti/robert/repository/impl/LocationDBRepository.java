package ro.uti.robert.repository.impl;

import org.hibernate.query.Query;
import ro.uti.robert.AdvancedWriter;
import ro.uti.robert.model.AddressDB;
import ro.uti.robert.model.CoordinatesDB;
import ro.uti.robert.model.LocationDB;
import ro.uti.robert.repository.LocationRepository;

public class LocationDBRepository implements LocationRepository {

    public LocationDBRepository() {

    }

    @Override
    public LocationDB saveLocation(LocationDB locationDB, AddressDB addressDB, CoordinatesDB coordinatesDB) {
        Query query = AdvancedWriter.getSession().createQuery("select id from LocationDB " +
                " where description = '" + locationDB.getDescription() + "'"
                + " and coordinatesId = " + coordinatesDB.getId()
                + " and addressId = " + addressDB.getId()
        );

        Integer id = (Integer) query.uniqueResult();
        if (id == null) {
            AdvancedWriter.getSession().save(locationDB);
        } else {
            locationDB.setId(id);
        }

        return locationDB;


    }

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
