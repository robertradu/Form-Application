package ro.uti.robert.repository.impl;

import ro.uti.robert.Writer;
import ro.uti.robert.model.AgentDB;
import ro.uti.robert.repository.AgentRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AgentDBRepository implements AgentRepository {

    public void setUp() {
        Writer.connect();
    }

    public AgentDBRepository() {
        setUp();
    }

    @Override
    public AgentDB saveAgent(AgentDB agentDB) {
        try {
            PreparedStatement preparedStatement = Writer.connection.prepareStatement("INSERT INTO validated_forms.agent (individualperson_id) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, agentDB.getIndividualPersonId());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                agentDB.setId(resultSet.getInt(1));
            }
            return agentDB;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public boolean checkForExistence(AgentDB agentDB) {
        try {
            PreparedStatement preparedStatement = Writer.connection.prepareStatement(
                    "SELECT * FROM validated_forms.agent where individualperson_id = " + agentDB.getIndividualPersonId());

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
    public void deleteAgent(int id) {

    }
}
