package ro.uti.robert.repository.impl;

import org.hibernate.query.Query;
import ro.uti.robert.AdvancedWriter;
import ro.uti.robert.model.InjuredPersonDB;
import ro.uti.robert.repository.InjuredPersonRepository;

import javax.swing.*;

public class InjuredPersonDBRepository implements InjuredPersonRepository {

    public InjuredPersonDBRepository() {

    }

    @Override
    public InjuredPersonDB saveInjuredPerson(InjuredPersonDB injuredPersonDB) {
        Integer id = getInjuredPersonId(injuredPersonDB);

        if (id == null) {
            AdvancedWriter.getSession().save(injuredPersonDB);
        } else {
            injuredPersonDB.setId(id);
        }
        return injuredPersonDB;


    }

    @Override
    public Integer getInjuredPersonId(InjuredPersonDB injuredPersonDB) {
        Query query = AdvancedWriter.getSession().createQuery("select id from InjuredPersonDB " +
                " where personId = " + injuredPersonDB.getPersonId());


        Integer id = (Integer) query.uniqueResult();
        return id;
    }

    @Override
    public InjuredPersonDB getInjuredPerson(int id) {
        InjuredPersonDB injuredPersonDB = AdvancedWriter.getSession().get(InjuredPersonDB.class, id);

        if (injuredPersonDB != null) {
            return injuredPersonDB;
        }
        JOptionPane.showMessageDialog(null, "No record with id = : " + id);
        return null;
    }

    @Override
    public Long countInjuredPersons() {
        Query query = AdvancedWriter.getSession().createQuery("select count(id) from InjuredPersonDB");

        Long id = (Long) query.uniqueResult();
        return id;
    }

    /*@Override
    public boolean checkForExistence(InjuredPersonDB injuredPersonDB) {
        try {
            PreparedStatement preparedStatement = AdvancedWriter.getConnection().prepareStatement(
                    "SELECT * FROM validated_forms.injuredperson where person_id = '" + injuredPersonDB.getPersonId() + "'");

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
    public void deleteInjuredPerson(int id) {

    }*/
}
