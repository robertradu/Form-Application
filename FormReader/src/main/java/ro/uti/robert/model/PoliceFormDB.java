package ro.uti.robert.model;

import java.time.LocalDateTime;

public class PoliceFormDB {
    private Integer id;
    private Integer applicantId;
    private String details;
    private String authorizationNr;
    private Integer locationId;
    private Integer injuredPersonId;
    private Integer agentId;
    private LocalDateTime recordDate;


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

    public Integer getInjuredPersonId() {
        return injuredPersonId;
    }

    public void setInjuredPersonId(Integer injuredPersonId) {
        this.injuredPersonId = injuredPersonId;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public LocalDateTime getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDateTime recordDate) {
        this.recordDate = recordDate;
    }
}
