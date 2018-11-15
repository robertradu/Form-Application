package ro.uti.robert.mapper;

import com.primarie.model.PoliceForm;
import ro.uti.robert.model.*;

public class PoliceFormMapper {
    private PoliceFormDB policeFormDB;
    private PoliceForm policeForm;
    private ApplicantDB applicantDB;
    private ApplicantMapper applicantMapper;
    private LocationDB locationDB;
    private LocationMapper locationMapper;
    private InjuredPersonDB injuredPersonDB;
    private InjuredPersonMapper injuredPersonMapper;
    private AgentDB agentDB;
    private AgentMapper agentMapper;


    public PoliceFormMapper(ApplicantDB applicantDB, ApplicantMapper applicantMapper, LocationDB locationDB,
                            LocationMapper locationMapper, InjuredPersonDB injuredPersonDB,
                            InjuredPersonMapper injuredPersonMapper, AgentDB agentDB,
                            AgentMapper agentMapper) {
        this.policeForm = new PoliceForm();
        this.policeFormDB = new PoliceFormDB();
        this.applicantDB = applicantDB;
        this.applicantMapper = applicantMapper;
        this.locationDB = locationDB;
        this.locationMapper = locationMapper;
        this.injuredPersonDB = injuredPersonDB;
        this.injuredPersonMapper = injuredPersonMapper;
        this.agentDB = agentDB;
        this.agentMapper = agentMapper;

    }

    public PoliceFormDB toPoliceFormDB(PoliceForm policeForm) {
        policeFormDB.setApplicantId(applicantDB.getId());
        policeFormDB.setDetails(policeForm.getDetails());
        policeFormDB.setAuthorizationNr(policeForm.getAuthorizationNr());
        policeFormDB.setLocationId(locationDB.getId());
        policeFormDB.setInjuredPersonId(injuredPersonDB.getId());
        policeFormDB.setAgentId(agentDB.getId());
        policeFormDB.setRecordDate(policeForm.getRecordDate());

        return policeFormDB;
    }

    /*public PoliceForm toPoliceForm(PoliceFormDB policeFormDB) {
        policeForm.setApplicant(applicantMapper.toApplicantDB(personMapper.toPerson(personDB.)));
        policeForm.setDetails(policeForm.getDetails());
        policeForm.setAuthorizationNr(policeForm.getAuthorizationNr());
        policeForm.setLocationId(locationDB.getId());
        policeForm.setInjuredPersonId(injuredPersonDB.getId());
        policeForm.setAgentId(agentDB.getId());
        policeForm.setRecordDate(policeForm.getRecordDate());

        return policeForm;
    }*/
}
