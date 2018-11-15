package ro.uti.robert.repository.impl;

import org.hibernate.query.Query;
import ro.uti.robert.AdvancedWriter;
import ro.uti.robert.model.InjuredPersonDB;
import ro.uti.robert.repository.InjuredPersonRepository;

public class InjuredPersonDBRepository implements InjuredPersonRepository {

    public InjuredPersonDBRepository() {

    }

    @Override
    public InjuredPersonDB saveInjuredPerson(InjuredPersonDB injuredPersonDB) {

        Query query = AdvancedWriter.getSession().createQuery("select id from InjuredPersonDB " +
                " where personId = " + injuredPersonDB.getPersonId());


        Integer id = (Integer) query.uniqueResult();

        if (id == null) {
            AdvancedWriter.getSession().save(injuredPersonDB);
        } else {
            injuredPersonDB.setId(id);
        }
        return injuredPersonDB;



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
