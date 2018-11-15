package ro.uti.robert.model;

import com.primarie.model.HospitalForm;

import java.time.LocalDateTime;

public class HospitalFormDB {

    private Integer id;
    private Integer applicantId;
    private String details;
    private String authorizationNr;
    private Integer locationId;
    private Integer pacientId;
    private String equipment;
    private LocalDateTime recordDate;

    public HospitalFormDB() {
    }

    public HospitalFormDB(HospitalForm hospitalForm, ApplicantDB applicantDB, LocationDB locationDB, PacientDB pacientDB) {
        this.applicantId = applicantDB.getId();
        this.details = hospitalForm.getDetails();
        this.authorizationNr = hospitalForm.getAuthorizationNr();
        this.locationId = locationDB.getId();
        this.pacientId = pacientDB.getId();
        this.equipment = hospitalForm.getEquipment();
        this.recordDate = hospitalForm.getRecordDate();
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

    public String getAuthorizationNr() {
        return authorizationNr;
    }

    public void setAuthorizationNr(String authorizationNr) {
        this.authorizationNr = authorizationNr;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getPacientId() {
        return pacientId;
    }

    public void setPacientId(Integer pacientId) {
        this.pacientId = pacientId;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public LocalDateTime getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDateTime recordDate) {
        this.recordDate = recordDate;
    }
}
