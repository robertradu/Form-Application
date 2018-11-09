package ro.uti.robert.repository.impl;

import ro.uti.robert.Writer;
import ro.uti.robert.model.PersonDB;
import ro.uti.robert.repository.PersonRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonDBRepository implements PersonRepository {
    private PersonDB personDB;

    public void setUp() {
        Writer.connect();
    }

    public PersonDBRepository() {
        setUp();
    }

    @Override
    public PersonDB savePerson(PersonDB personDB) {

        try {
            PreparedStatement preparedStatement;
            if (personDB.getLegalPersonId() == null) {
                preparedStatement = Writer.connection.prepareStatement("INSERT INTO validated_forms.person (individual_person_id, telephone, address_id) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setInt(1, personDB.getIndividualPersonId());
                preparedStatement.setString(2, personDB.getTelephone());
                preparedStatement.setInt(3, personDB.getAddressId());
                preparedStatement.executeUpdate();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    personDB.setId(resultSet.getInt(1));
                }
                return personDB;
            } else {
                if (personDB.getIndividualPersonId() == null) {
                    preparedStatement = Writer.connection.prepareStatement("INSERT INTO validated_forms.person (legal_person_id, telephone, address_id) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
                    preparedStatement.setInt(1, personDB.getLegalPersonId());
                    preparedStatement.setString(2, personDB.getTelephone());
                    preparedStatement.setInt(3, personDB.getAddressId());
                    preparedStatement.executeUpdate();
                    ResultSet resultSet = preparedStatement.getGeneratedKeys();
                    if (resultSet.next()) {
                        personDB.setId(resultSet.getInt(1));
                    }
                    return personDB;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean checkForExistence(PersonDB personDB) {
        try {
            PreparedStatement preparedStatement = Writer.connection.prepareStatement(
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

    }
}
