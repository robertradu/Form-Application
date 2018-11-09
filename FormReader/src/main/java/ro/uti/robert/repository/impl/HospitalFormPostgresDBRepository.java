package ro.uti.robert.repository.impl;

import com.primarie.model.HospitalForm;
import ro.uti.robert.Writer;
import ro.uti.robert.model.*;
import ro.uti.robert.repository.HospitalFormRepository;

import java.sql.*;

public class HospitalFormPostgresDBRepository implements HospitalFormRepository {
    private HospitalForm hospitalForm;

    public void setUp() {
        Writer.connect();
    }

    public HospitalFormPostgresDBRepository() {
        setUp();
    }


    @Override
    public HospitalFormDB saveHospitalForm(HospitalFormDB hospitalFormDB) {
        try {
            PreparedStatement preparedStatement = Writer.connection.prepareStatement(
                    "INSERT INTO validated_forms.hospitalform (applicant_id, details, authorizationnr, location_id," +
                            " pacient_id, equipment, data) VALUES (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, hospitalFormDB.getApplicantId());
            preparedStatement.setString(2, hospitalFormDB.getDetails());
            preparedStatement.setString(3, hospitalFormDB.getAuthorizationNr());
            preparedStatement.setInt(4, hospitalFormDB.getLocationId());
            preparedStatement.setInt(5, hospitalFormDB.getPacientId());
            preparedStatement.setString(6, hospitalFormDB.getEquipment());
            preparedStatement.setTimestamp(7, Timestamp.valueOf(hospitalFormDB.getRecordDate()));
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                hospitalFormDB.setId(resultSet.getInt(1));
            }
            return hospitalFormDB;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public HospitalFormDB getHospitalForm(Long id) {
        return null;
    }

    @Override
    public void deleteHospitalForm(Long id) {

    }

    @Override
    public Long countHospitalForms() {
        return null;
    }
}
