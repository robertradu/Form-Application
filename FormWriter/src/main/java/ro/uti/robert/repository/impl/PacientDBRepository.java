package ro.uti.robert.repository.impl;

import ro.uti.robert.Writer;
import ro.uti.robert.model.PacientDB;
import ro.uti.robert.repository.PacientRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PacientDBRepository implements PacientRepository {

    public void setUp() {
        Writer.connect();
    }

    public PacientDBRepository() {
        setUp();
    }

    @Override
    public PacientDB savePacientDB(PacientDB pacientDB) {
        try {
            PreparedStatement preparedStatement = Writer.connection.prepareStatement
                    ("INSERT INTO validated_forms.pacient (individualperson_id) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, pacientDB.getIndividualPersonId());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                pacientDB.setId(resultSet.getInt(1));
            }
            return pacientDB;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean checkForExistence(PacientDB pacientDB) {
        try {
            PreparedStatement preparedStatement = Writer.connection.prepareStatement(
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

    }
}
