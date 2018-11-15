package ro.uti.robert.repository.impl;

import com.primarie.model.Person;
import ro.uti.robert.Writer;
import ro.uti.robert.model.LegalPersonDB;
import ro.uti.robert.repository.LegalPersonRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LegalPersonDBRepository implements LegalPersonRepository {
    private LegalPersonDB legalPersonDB;
    private Person person;

    public void setUp() {
        Writer.connect();
    }

    public LegalPersonDBRepository() {
        setUp();
    }

    @Override
    public LegalPersonDB saveLegalPerson(LegalPersonDB legalPersonDB) {
        try {
            PreparedStatement preparedStatement = Writer.connection.prepareStatement(
                    "INSERT INTO validated_forms.legalperson (name, cif) " +
                            "VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, legalPersonDB.getName());
            preparedStatement.setString(2, legalPersonDB.getCif());
            preparedStatement.executeUpdate();


            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                legalPersonDB.setId(resultSet.getInt(1));
            }

            return legalPersonDB;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean checkForExistence(LegalPersonDB legalPersonDB) {
        try {
            PreparedStatement preparedStatement = Writer.connection.prepareStatement(
                    "SELECT * FROM validated_forms.legalperson where cif = " + legalPersonDB.getCif());

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
    public void deleteLegalPerson(int id) {

    }

    public LegalPersonDB getLegalPersonDB() {
        return legalPersonDB;
    }

    public void setLegalPersonDB(LegalPersonDB legalPersonDB) {
        this.legalPersonDB = legalPersonDB;
    }
}
