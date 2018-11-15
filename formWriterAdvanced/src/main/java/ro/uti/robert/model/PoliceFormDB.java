package ro.uti.robert.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "validated_forms.policeform")
public class PoliceFormDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "applicant_id")
    private Integer applicantId;
    private String details;
    private String authorizationNr;
    @Column(name = "location_id")
    private Integer locationId;
    @Column(name = "injuredperson_id")
    private Integer injuredPersonId;
    @Column(name = "agent_id")
    private Integer agentId;
    @Column(name = "data")
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

    @Override
    public String toString() {
        return "PoliceFormDB{" +
                "id=" + id +
                ", applicantId=" + applicantId +
                ", details='" + details + '\'' +
                ", authorizationNr='" + authorizationNr + '\'' +
                ", locationId=" + locationId +
                ", injuredPersonId=" + injuredPersonId +
                ", agentId=" + agentId +
                ", recordDate=" + recordDate +
                '}';
    }
}
