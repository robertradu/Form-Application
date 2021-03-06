package ro.uti.robert.model;

import com.primarie.model.CompanyForm;
import com.primarie.model.HospitalForm;

import java.time.LocalDateTime;

public class CompanyFormDB {
    private Integer id;
    private Integer applicantId;
    private String details;
    private Integer locationId;
    private String contractNr;
    private LocalDateTime recordDate;

    public CompanyFormDB() {
    }

    public CompanyFormDB(CompanyForm companyForm, ApplicantDB applicantDB, LocationDB locationDB) {
        this.applicantId = applicantDB.getId();
        this.details = companyForm.getDetails();
        this.contractNr = companyForm.getContractNr();
        this.locationId = locationDB.getId();
        this.recordDate = companyForm.getRecordDate();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getContractNr() {
        return contractNr;
    }

    public void setContractNr(String contractNr) {
        this.contractNr = contractNr;
    }

    public LocalDateTime getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDateTime recordDate) {
        this.recordDate = recordDate;
    }
}
