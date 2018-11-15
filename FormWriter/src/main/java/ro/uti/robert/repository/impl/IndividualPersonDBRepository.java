package ro.uti.robert.repository.impl;

import com.primarie.model.Person;
import ro.uti.robert.Writer;
import ro.uti.robert.model.IndividualPersonDB;
import ro.uti.robert.repository.IndividualPersonRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IndividualPersonDBRepository implements IndividualPersonRepository {
    private IndividualPersonDB individualPersonDB;
    private Person person;

    public static void setUp() {
        Writer.connect();
    }

    public IndividualPersonDBRepository() {
        setUp();
    }

    @Override
    public IndividualPersonDB saveIndividualPerson(IndividualPersonDB individualPersonDB) {
        try {
            PreparedStatement preparedStatement = Writer.connection.prepareStatement(
                    "INSERT INTO validated_forms.individualperson(cnp, lastname, firstname, citizenship) " +
                            "VALUES (?,?,?,?) ", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, individualPersonDB.getCnp());
            preparedStatement.setString(2, individualPersonDB.getLastName());
            preparedStatement.setString(3, individualPersonDB.getFirstName());
            preparedStatement.setString(4, individualPersonDB.getCitizenship());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                individualPersonDB.setId(resultSet.getInt(1));
            }
            return individualPersonDB;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean checkForExistence(IndividualPersonDB individualPersonDB) {
        try {
            PreparedStatement preparedStatement = Writer.connection.prepareStatement(
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
    }
}
