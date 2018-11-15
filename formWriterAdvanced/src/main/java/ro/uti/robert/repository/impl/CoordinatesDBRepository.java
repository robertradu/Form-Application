package ro.uti.robert.repository.impl;

import org.hibernate.query.Query;
import ro.uti.robert.AdvancedWriter;
import ro.uti.robert.model.CoordinatesDB;
import ro.uti.robert.repository.CoordinatesRepository;

public class CoordinatesDBRepository implements CoordinatesRepository {

    public CoordinatesDBRepository() {

    }

    @Override
    public CoordinatesDB saveCoordinates(CoordinatesDB coordinatesDB) {

        Query query = AdvancedWriter.getSession().createQuery("select id from CoordinatesDB" +
                " where altitude = " + coordinatesDB.getAltitude()
                + " and latitude = " + coordinatesDB.getLatitude()
                + " and longitude = " + coordinatesDB.getLongitude());

        Integer id = (Integer) query.uniqueResult();

        if (id == null) {
            AdvancedWriter.getSession().save(coordinatesDB);
        } else {
            coordinatesDB.setId(id);
        }

        return coordinatesDB;
    }

    /*@Override
    public void deleteCoordinates(int id) {
        try {
            PreparedStatement preparedStatement = AdvancedWriter.geconnection.prepareStatement("DELETE FROM validated_forms.coordinates WHERE id = " + id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/


}
