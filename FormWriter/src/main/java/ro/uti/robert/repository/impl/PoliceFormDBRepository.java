package ro.uti.robert.repository.impl;

import ro.uti.robert.Writer;
import ro.uti.robert.model.PoliceFormDB;
import ro.uti.robert.repository.PoliceFormRepository;

import java.sql.*;

public class PoliceFormDBRepository implements PoliceFormRepository {

    public void setUp() {
        Writer.connect();
    }

    public PoliceFormDBRepository() {
        setUp();
    }

    @Override
    public PoliceFormDB savePoliceForm(PoliceFormDB policeFormDB) {
        try {
            PreparedStatement preparedStatement = Writer.connection.prepareStatement("INSERT INTO validated_forms.policeform " +
                    "(applicant_id, details, authorizationnr," +
                    " location_id, injuredperson_id, agent_id, data) " +
                    "VALUES (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, policeFormDB.getApplicantId());
            preparedStatement.setString(2, policeFormDB.getDetails());
            preparedStatement.setString(3, policeFormDB.getAuthorizationNr());
            preparedStatement.setInt(4, policeFormDB.getLocationId());
            preparedStatement.setInt(5, policeFormDB.getInjuredPersonId());
            preparedStatement.setInt(6, policeFormDB.getAgentId());
            preparedStatement.setTimestamp(7, Timestamp.valueOf(policeFormDB.getRecordDate()));
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                policeFormDB.setId(resultSet.getInt(1));
            }
            return policeFormDB;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public void deletePoliceForm(int id) {

    }
}
