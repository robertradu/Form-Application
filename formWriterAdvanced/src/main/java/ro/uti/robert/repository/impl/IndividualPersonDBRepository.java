package ro.uti.robert.repository.impl;

import org.hibernate.query.Query;
import ro.uti.robert.AdvancedWriter;
import ro.uti.robert.model.IndividualPersonDB;
import ro.uti.robert.repository.IndividualPersonRepository;

public class IndividualPersonDBRepository implements IndividualPersonRepository {

    public IndividualPersonDBRepository() {

    }

    @Override
    public IndividualPersonDB saveIndividualPerson(IndividualPersonDB individualPersonDB) {
        Query query = AdvancedWriter.getSession().createQuery("select id from IndividualPersonDB " +
                " where cnp = '" + individualPersonDB.getCnp() + "'"
                + " and lastname = '" + individualPersonDB.getLastName() + "'"
                + " and firstname = '" + individualPersonDB.getFirstName() + "'"
                + " and citizenship = '" + individualPersonDB.getCitizenship() + "'");


        Integer id = (Integer) query.uniqueResult();
        if (id == null) {
            AdvancedWriter.getSession().save(individualPersonDB);
        } else {
            individualPersonDB.setId(id);
        }
        return individualPersonDB;

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
