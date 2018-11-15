package ro.uti.robert.mapper;

import com.primarie.model.HospitalForm;
import com.primarie.model.PoliceForm;
import ro.uti.robert.model.*;

public class HospitalFormMapper {
    private HospitalFormDB hospitalFormDB;
    private HospitalForm hospitalForm;
    private ApplicantDB applicantDB;
    private ApplicantMapper applicantMapper;
    private LocationDB locationDB;
    private LocationMapper locationMapper;
    private PacientDB pacientDB;
    private PacientMapper pacientMapper;


    public HospitalFormMapper(ApplicantDB applicantDB, ApplicantMapper applicantMapper, LocationDB locationDB,
                              LocationMapper locationMapper, PacientDB pacientDB,
                              PacientMapper pacientMapper) {
        this.hospitalForm = new HospitalForm();
        this.hospitalFormDB = new HospitalFormDB();
        this.applicantDB = applicantDB;
        this.applicantMapper = applicantMapper;
        this.locationDB = locationDB;
        this.locationMapper = locationMapper;
        this.pacientDB = pacientDB;
        this.pacientMapper = pacientMapper;
    }

    public HospitalFormDB toHospitalFormDB(HospitalForm hospitalForm) {
        hospitalFormDB.setApplicantId(applicantDB.getId());
        hospitalFormDB.setDetails(hospitalForm.getDetails());
        hospitalFormDB.setAuthorizationNr(hospitalForm.getAuthorizationNr());
        hospitalFormDB.setLocationId(locationDB.getId());
        hospitalFormDB.setPacientId(pacientDB.getId());
        hospitalFormDB.setEquipment(hospitalForm.getEquipment());
        hospitalFormDB.setRecordDate(hospitalForm.getRecordDate());

        return hospitalFormDB;
    }


}
