package ro.uti.robert.repository.impl;

import org.hibernate.query.Query;
import ro.uti.robert.AdvancedWriter;
import ro.uti.robert.model.IndividualPersonDB;
import ro.uti.robert.repository.IndividualPersonRepository;

import javax.swing.*;

public class IndividualPersonDBRepository implements IndividualPersonRepository {

    public IndividualPersonDBRepository() {

    }

    @Override
    public IndividualPersonDB saveIndividualPerson(IndividualPersonDB individualPersonDB) {
        Integer id = getIndividualPersonId(individualPersonDB);

        if (id == null) {
            AdvancedWriter.getSession().save(individualPersonDB);
        } else {
            individualPersonDB.setId(id);
        }
        return individualPersonDB;

    }

    @Override
    public Integer getIndividualPersonId(IndividualPersonDB individualPersonDB) {
        Query query = AdvancedWriter.getSession().createQuery("select id from IndividualPersonDB " +
                " where cnp = '" + individualPersonDB.getCnp() + "'"
                + " and lastname = '" + individualPersonDB.getLastName() + "'"
                + " and firstname = '" + individualPersonDB.getFirstName() + "'"
                + " and citizenship = '" + individualPersonDB.getCitizenship() + "'");


        Integer id = (Integer) query.uniqueResult();
        return id;
    }

    @Override
    public IndividualPersonDB getIndividualPerson(int id) {
        IndividualPersonDB individualPersonDB = AdvancedWriter.getSession().get(IndividualPersonDB.class, id);

        if (individualPersonDB != null) {
            return individualPersonDB;
        }
        JOptionPane.showMessageDialog(null, "No record with id = : " + id);
        return null;
    }

    @Override
    public Long countIndividualPersons() {
        Query query = AdvancedWriter.getSession().createQuery("select count(id) from IndividualPersonDB");

        Long id = (Long) query.uniqueResult();
        return id;
    }

   /* @Override
    public boolean checkForExistence(IndividualPersonDB individualPersonDB) {
        try {
            PreparedStatement preparedStatement = AdvancedWriter.getConnection().prepareStatement(
                    "SELECT * FROM validated_forms.individualperson where cnp = '" + individualPersonDB.getCnp() + "'");

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

    public IndividualPersonDB getIndividualPersonDB() {
        return individualPersonDB;
    }

    public void setIndividualPersonDB(IndividualPersonDB individualPersonDB) {
        this.individualPersonDB = individualPersonDB;
    }

    @Override
    public IndividualPersonDB getIndividualPerson(Long id) {
        return null;
    }

    @Override
    public void deleteIndividualPerson(Long id) {

    }

    @Override
    public Long countIndividualPersons() {
        return null;
    }*/
}
