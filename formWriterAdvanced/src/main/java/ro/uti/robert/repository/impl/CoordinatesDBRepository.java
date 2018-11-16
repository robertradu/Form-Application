package ro.uti.robert.repository.impl;

import org.hibernate.query.Query;
import ro.uti.robert.AdvancedWriter;
import ro.uti.robert.model.CoordinatesDB;
import ro.uti.robert.repository.CoordinatesRepository;

import javax.swing.*;

public class CoordinatesDBRepository implements CoordinatesRepository {

    public CoordinatesDBRepository() {

    }

    @Override
    public CoordinatesDB saveCoordinates(CoordinatesDB coordinatesDB) {
        Integer id = getCoordinatesId(coordinatesDB);

        if (id == null) {
            AdvancedWriter.getSession().save(coordinatesDB);
        } else {
            coordinatesDB.setId(id);
        }

        return coordinatesDB;
    }

    @Override
    public Integer getCoordinatesId(CoordinatesDB coordinatesDB) {
        Query query = AdvancedWriter.getSession().createQuery("select id from CoordinatesDB" +
                " where altitude = " + coordinatesDB.getAltitude()
                + " and latitude = " + coordinatesDB.getLatitude()
                + " and longitude = " + coordinatesDB.getLongitude());

        Integer id = (Integer) query.uniqueResult();
        return id;
    }

    @Override
    public CoordinatesDB getCoordinates(int id) {
        CoordinatesDB coordinatesDB = AdvancedWriter.getSession().get(CoordinatesDB.class, id);
        if (coordinatesDB != null) {
            return coordinatesDB;
        }
        JOptionPane.showMessageDialog(null, "No record with id = : " + id);
        return null;

    }

    @Override
    public Long countCoordinates() {
        Query query = AdvancedWriter.getSession().createQuery("select count(id) from CoordinatesDB");

        Long id = (Long) query.uniqueResult();
        return id;
    }

    @Override
    public void deleteCoordinates(int id) {
        CoordinatesDB coordinatesDB = getCoordinates(id);
        AdvancedWriter.getSession().remove(coordinatesDB);
    }


}
