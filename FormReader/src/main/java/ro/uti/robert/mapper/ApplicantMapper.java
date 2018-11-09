package ro.uti.robert.mapper;

import ro.uti.robert.model.ApplicantDB;
import ro.uti.robert.model.PersonDB;

public class ApplicantMapper {
    private ApplicantDB applicantDB;
    private PersonDB personDB;

    public ApplicantMapper() {
        applicantDB = new ApplicantDB();
        personDB = new PersonDB();
    }

    public ApplicantDB toApplicantDB(PersonDB personDB) {
        applicantDB.setId(personDB.getId());
        applicantDB.setIndividualPersonId(personDB.getIndividualPersonId());
        applicantDB.setLegalPersonId(personDB.getLegalPersonId());

        return applicantDB;
    }
}
