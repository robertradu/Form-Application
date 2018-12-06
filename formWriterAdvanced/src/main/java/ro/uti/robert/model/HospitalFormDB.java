package ro.uti.robert.model;

import com.primarie.model.HospitalForm;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "validated_forms.hospitalform")
public class HospitalFormDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "applicant_id")
    private Integer applicantId;
    private String details;
    private String authorizationNr;
    @Column(name = "location_id")
    private Integer locationId;
    @Column(name = "pacient_id")
    private Integer pacientId;
    private String equipment;
    @Column(name = "data")
    private LocalDateTime recordDate;


    /*
    TODO: de facut relationare intre entitati (one to many, many to one ......)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="pacient_id")
    private Person pacient;
    */

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

    @Override
    public String toString() {
        return "HospitalFormDB{" +
                "id=" + id +
                ", applicantId=" + applicantId +
                ", details='" + details + '\'' +
                ", authorizationNr='" + authorizationNr + '\'' +
                ", locationId=" + locationId +
                ", pacientId=" + pacientId +
                ", equipment='" + equipment + '\'' +
                ", recordDate=" + recordDate +
                '}';
    }
}
