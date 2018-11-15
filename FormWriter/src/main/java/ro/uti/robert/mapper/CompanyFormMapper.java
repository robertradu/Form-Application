package ro.uti.robert.mapper;

import com.primarie.model.CompanyForm;
import com.primarie.model.HospitalForm;
import ro.uti.robert.model.*;

public class CompanyFormMapper {
    private CompanyFormDB companyFormDB;
    private CompanyForm companyForm;
    private ApplicantDB applicantDB;
    private ApplicantMapper applicantMapper;
    private LocationDB locationDB;
    private LocationMapper locationMapper;


    public CompanyFormMapper(ApplicantDB applicantDB, ApplicantMapper applicantMapper, LocationDB locationDB,
                             LocationMapper locationMapper) {
        this.companyForm = new CompanyForm();
        this.companyFormDB = new CompanyFormDB();
        this.applicantDB = applicantDB;
        this.applicantMapper = applicantMapper;
        this.locationDB = locationDB;
        this.locationMapper = locationMapper;
    }

    public CompanyFormDB toCompanyFormDB(CompanyForm companyForm) {
        companyFormDB.setApplicantId(applicantDB.getId());
        companyFormDB.setDetails(companyForm.getDetails());
        companyFormDB.setContractNr(companyForm.getContractNr());
        companyFormDB.setLocationId(locationDB.getId());
        companyFormDB.setRecordDate(companyForm.getRecordDate());

        return companyFormDB;
    }
}
