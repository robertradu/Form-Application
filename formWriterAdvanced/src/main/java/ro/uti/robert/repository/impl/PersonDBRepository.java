package ro.uti.robert.repository.impl;

import org.hibernate.query.Query;
import ro.uti.robert.AdvancedWriter;
import ro.uti.robert.model.PersonDB;
import ro.uti.robert.repository.PersonRepository;

import javax.swing.*;

public class PersonDBRepository implements PersonRepository {

    public PersonDBRepository() {

    }

    @Override
    public PersonDB savePerson(PersonDB personDB) {
        Integer id = getPersonId(personDB);

        if (id == null) {
            AdvancedWriter.getSession().save(personDB);
        } else {
            personDB.setId(id);
        }

        return personDB;

    }

    @Override
    public Integer getPersonId(PersonDB personDB) {
        Query query = AdvancedWriter.getSession().createQuery("select id from PersonDB " +
                " where individualPersonId = " + personDB.getIndividualPersonId()
                + " and legalPersonId = " + personDB.getLegalPersonId()
                + " and telephone = '" + personDB.getTelephone() + "'"
                + " and addressId = " + personDB.getAddressId());


        Integer id = (Integer) query.uniqueResult();
        return id;
    }

    @Override
    public PersonDB getPerson(int id) {
        PersonDB personDB = AdvancedWriter.getSession().get(PersonDB.class, id);

        if (personDB != null) {
            return personDB;
        }
        JOptionPane.showMessageDialog(null, "No record with id = : " + id);
        return null;
    }

    @Override
    public Long countPersons() {
        Query query = AdvancedWriter.getSession().createQuery("select count(id) from PersonDB");

        Long id = (Long) query.uniqueResult();
        return id;    }

   /* @Override
    public boolean checkForExistence(PersonDB personDB) {
        try {
            PreparedStatement preparedStatement = AdvancedWriter.getConnection().prepareStatement(
                    "SELECT * FROM validated_forms.person where " +
                            "individual_person_id = " + personDB.getIndividualPersonId()
                            + " and legal_person_id = " + personDB.getLegalPersonId()
                            + " and telephone = '" + personDB.getTelephone() + "'"
                            + " and address_id = " + personDB.getAddressId());

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

    public PersonDB getPersonDB() {
        return personDB;
    }

    public void setPersonDB(PersonDB personDB) {
        this.personDB = personDB;
    }

    @Override
    public void deletePerson(int id) {

    }*/
}
