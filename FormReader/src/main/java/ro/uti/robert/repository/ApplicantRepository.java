package ro.uti.robert.repository;

import ro.uti.robert.model.ApplicantDB;

public interface ApplicantRepository {
    ApplicantDB saveApplicant(ApplicantDB applicantDB);

    boolean checkForExistence(ApplicantDB applicantDB);

    void deleteApplicant(int id);
}
