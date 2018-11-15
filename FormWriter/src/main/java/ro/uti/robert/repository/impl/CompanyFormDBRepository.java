package ro.uti.robert.repository.impl;

import ro.uti.robert.Writer;
import ro.uti.robert.model.CompanyFormDB;
import ro.uti.robert.repository.CompanyFormRepository;

import java.sql.*;

public class CompanyFormDBRepository implements CompanyFormRepository {

    public void setUp() {
        Writer.connect();
    }

    public CompanyFormDBRepository() {
        setUp();
    }


    @Override
    public CompanyFormDB saveCompanyForm(CompanyFormDB companyFormDB) {
        try {
            PreparedStatement preparedStatement = Writer.connection.prepareStatement(
                    "INSERT INTO validated_forms.companyform (applicant_id, details, authorizationnr, location_id,data)" +
                            " VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, companyFormDB.getApplicantId());
            preparedStatement.setString(2, companyFormDB.getDetails());
            preparedStatement.setString(3, companyFormDB.getContractNr());
            preparedStatement.setInt(4, companyFormDB.getLocationId());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(companyFormDB.getRecordDate()));
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                companyFormDB.setId(resultSet.getInt(1));
            }
            return companyFormDB;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteCompanyForm(int id) {

    }
}
