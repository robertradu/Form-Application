package ro.uti.robert.repository.impl;

import org.hibernate.query.Query;
import ro.uti.robert.AdvancedWriter;
import ro.uti.robert.model.PacientDB;
import ro.uti.robert.repository.PacientRepository;

import javax.swing.*;

public class PacientDBRepository implements PacientRepository {

    public PacientDBRepository() {

    }

    @Override
    public PacientDB savePacientDB(PacientDB pacientDB) {
        Integer id = getPacientId(pacientDB);

        if (id == null) {
            AdvancedWriter.getSession().save(pacientDB);
        } else {
            pacientDB.setId(id);
        }
        return pacientDB;
    }

    @Override
    public Integer getPacientId(PacientDB pacientDB) {
        Query query = AdvancedWriter.getSession().createQuery("select id from PacientDB " +
                " where individualPersonId = " + pacientDB.getIndividualPersonId());

        Integer id = (Integer) query.uniqueResult();
        return id;
    }

    @Override
    public PacientDB getPacient(int id) {
        PacientDB pacientDB = AdvancedWriter.getSession().get(PacientDB.class, id);

        if (pacientDB != null) {
            return pacientDB;
        }
        JOptionPane.showMessageDialog(null, "No record with id = : " + id);
        return null;
    }

    @Override
    public Long countPacients() {
        Query query = AdvancedWriter.getSession().createQuery("select count(id) from PacientDB");

        Long id = (Long) query.uniqueResult();
        return id;

    }

    /*@Override
    public boolean checkForExistence(PacientDB pacientDB) {
        try {
            PreparedStatement preparedStatement = AdvancedWriter.getConnection().prepareStatement(
                    "SELECT * FROM validated_forms.pacient where individualperson_id = " + pacientDB.getIndividualPersonId());

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
    public void deletePacientDB(int id) {

    }*/
}
