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

    /**
     * Searches the id of the specified record of type {@link ApplicantDB} exists
     *
     * @param applicantDB
     * @return
     */
    Integer getApplicantId(ApplicantDB applicantDB);

    /**
     * Searches the specified record of type {@link ApplicantDB}
     * @param id
     * @return
     */
    ApplicantDB getApplicant(int id);

    /**
     * Counts all entities {@link ApplicantDB} existent in DB
     * @return
     */
    Long countApplicants();

   // boolean checkForExistence(ApplicantDB applicantDB);

 //   void deleteApplicant(int id);
}
