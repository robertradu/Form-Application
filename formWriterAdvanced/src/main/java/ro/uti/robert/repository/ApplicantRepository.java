package ro.uti.robert.repository;

import ro.uti.robert.model.ApplicantDB;

public interface ApplicantRepository {
    /**
     * Creates or updates an entity of type {@link ApplicantDB}.
     *
     * @param applicantDB
     * @return: return the ID for created entity
     */
    ApplicantDB saveApplicant(ApplicantDB applicantDB);

   // boolean checkForExistence(ApplicantDB applicantDB);

 //   void deleteApplicant(int id);
}
