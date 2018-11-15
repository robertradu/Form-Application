package ro.uti.robert.repository.impl;

import ro.uti.robert.Writer;
import ro.uti.robert.model.InjuredPersonDB;
import ro.uti.robert.repository.InjuredPersonRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InjuredPersonDBRepository implements InjuredPersonRepository {
    private InjuredPersonDB injuredPersonDB;

    public void setUp() {
        Writer.connect();
    }

    public InjuredPersonDBRepository() {
        setUp();
    }

    @Override
    public InjuredPersonDB saveInjuredPerson(InjuredPersonDB injuredPersonDB) {

        try {
            PreparedStatement preparedStatement = Writer.connection.prepareStatement("INSERT INTO validated_forms.injuredperson (person_id) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, injuredPersonDB.getPersonId());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                injuredPersonDB.setId(resultSet.getInt(1));
            }

            return injuredPersonDB;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public boolean checkForExistence(InjuredPersonDB injuredPersonDB) {
        try {
            PreparedStatement preparedStatement = Writer.connection.prepareStatement(
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

    }
}
