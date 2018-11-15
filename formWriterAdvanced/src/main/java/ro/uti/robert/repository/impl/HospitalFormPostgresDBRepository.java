package ro.uti.robert.repository.impl;

import org.hibernate.query.Query;
import ro.uti.robert.AdvancedWriter;
import ro.uti.robert.model.HospitalFormDB;
import ro.uti.robert.repository.HospitalFormRepository;

public class HospitalFormPostgresDBRepository implements HospitalFormRepository {

    public HospitalFormPostgresDBRepository() {

    }

    @Override
    public HospitalFormDB saveHospitalForm(HospitalFormDB hospitalFormDB) {
        Query query = AdvancedWriter.getSession().createQuery("select id from HospitalFormDB " +
                " where applicantId = " + hospitalFormDB.getApplicantId()
                + " and details = '" + hospitalFormDB.getDetails() + "'"
                + " and authorizationNr = '" + hospitalFormDB.getAuthorizationNr() + "'"
                + " and locationId = '" + hospitalFormDB.getLocationId() + "'"
                + " and pacientId = '" + hospitalFormDB.getPacientId() + "'"
                + " and equipment = '" + hospitalFormDB.getEquipment() + "'"
                + " and recordDate = '" + hospitalFormDB.getRecordDate() + "'");


        AdvancedWriter.getSession().save(hospitalFormDB);

        return hospitalFormDB;
    }

   /* @Override
    public HospitalFormDB getHospitalForm(Long id) {
        return null;
    }

    @Override
    public void deleteHospitalForm(Long id) {

    }

    @Override
    public Long countHospitalForms() {
        return null;
    }*/
}
