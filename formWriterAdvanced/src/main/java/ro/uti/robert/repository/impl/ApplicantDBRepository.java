package ro.uti.robert.repository.impl;

import org.hibernate.query.Query;
import ro.uti.robert.AdvancedWriter;
import ro.uti.robert.model.ApplicantDB;
import ro.uti.robert.repository.ApplicantRepository;

import javax.swing.*;

public class ApplicantDBRepository implements ApplicantRepository {

    public ApplicantDBRepository() {

    }

    @Override
    public ApplicantDB saveApplicant(ApplicantDB applicantDB) {
        Integer id = getApplicantId(applicantDB);


        if (id == null) {
            AdvancedWriter.getSession().save(applicantDB);
        } else {
            applicantDB.setId(id);
        }

        return applicantDB;
    }

    @Override
    public Integer getApplicantId(ApplicantDB applicantDB) {
        Query query = AdvancedWriter.getSession().createQuery("select id from ApplicantDB " +
                " where individualPersonId = " + applicantDB.getIndividualPersonId()
                + " and legalPersonId = " + applicantDB.getLegalPersonId());

        Integer id = (Integer) query.uniqueResult();
        return id;
    }

    @Override
    public ApplicantDB getApplicant(int id) {
        ApplicantDB applicantDB = AdvancedWriter.getSession().get(ApplicantDB.class, id);

        if (applicantDB != null) {
            return applicantDB;
        }
        JOptionPane.showMessageDialog(null, "No record with id = : " + id);
        return null;
    }

    @Override
    public Long countApplicants() {
        Query query = AdvancedWriter.getSession().createQuery("select count(id) from ApplicantDB");

        Long id = (Long) query.uniqueResult();
        return id;
    }

   /* @Override
    public boolean checkForExistence(ApplicantDB applicantDB) {
        try {
            PreparedStatement preparedStatement = AdvancedWriter.getConnection().prepareStatement(
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

    }*/
}
