package ro.uti.robert.repository.impl;

import ro.uti.robert.Writer;
import ro.uti.robert.model.ApplicantDB;
import ro.uti.robert.repository.ApplicantRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ApplicantDBRepository implements ApplicantRepository {


    public void setUp() {
        Writer.connect();
    }

    public ApplicantDBRepository() {
        setUp();
    }

    @Override
    public ApplicantDB saveApplicant(ApplicantDB applicantDB) {


        try {
            if (applicantDB.getIndividualPersonId() != null) {
                PreparedStatement preparedStatement = Writer.connection.prepareStatement("INSERT INTO validated_forms.applicant (individualperson_id) VALUES (?)", Statement.RETURN_GENERATED_KEYS);


                preparedStatement.setInt(1, applicantDB.getIndividualPersonId());
                preparedStatement.executeUpdate();

                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    applicantDB.setId(resultSet.getInt(1));
                }
                return applicantDB;
            } else {
                if (applicantDB.getLegalPersonId() != null) {
                    PreparedStatement preparedStatement = Writer.connection.prepareStatement("INSERT INTO validated_forms.applicant (legalperson_id) VALUES (?)", Statement.RETURN_GENERATED_KEYS);

                    preparedStatement.setInt(1, applicantDB.getLegalPersonId());
                    preparedStatement.executeUpdate();

                    ResultSet resultSet = preparedStatement.getGeneratedKeys();
                    if (resultSet.next()) {
                        applicantDB.setId(resultSet.getInt(1));
                    }
                    return applicantDB;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public boolean checkForExistence(ApplicantDB applicantDB) {
        try {
            PreparedStatement preparedStatement = Writer.connection.prepareStatement(
                    "SELECT * FROM validated_forms.applicant where individualperson_id = " + applicantDB.getIndividualPersonId()
                            + " and legalperson_id = " + applicantDB.getLegalPersonId());

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
    public void deleteApplicant(int id) {

    }
}
