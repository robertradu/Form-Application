package ro.uti.robert.repository.impl;

import org.hibernate.query.Query;
import ro.uti.robert.AdvancedWriter;
import ro.uti.robert.model.HospitalFormDB;
import ro.uti.robert.repository.HospitalFormRepository;

import javax.swing.*;

public class HospitalFormPostgresDBRepository implements HospitalFormRepository {

    public HospitalFormPostgresDBRepository() {

    }

    @Override
    public HospitalFormDB saveHospitalForm(HospitalFormDB hospitalFormDB) {

        AdvancedWriter.getSession().save(hospitalFormDB);

        return hospitalFormDB;
    }

    @Override
    public Integer getHospitalFormId(HospitalFormDB hospitalFormDB) {
        Query query = AdvancedWriter.getSession().createQuery("select id from HospitalFormDB " +
                " where applicantId = " + hospitalFormDB.getApplicantId()
                + " and details = '" + hospitalFormDB.getDetails() + "'"
                + " and authorizationNr = '" + hospitalFormDB.getAuthorizationNr() + "'"
                + " and locationId = '" + hospitalFormDB.getLocationId() + "'"
                + " and pacientId = '" + hospitalFormDB.getPacientId() + "'"
                + " and equipment = '" + hospitalFormDB.getEquipment() + "'"
                + " and recordDate = '" + hospitalFormDB.getRecordDate() + "'");


        Integer id = (Integer) query.uniqueResult();
        return id;
    }

    @Override
    public HospitalFormDB getHospitalForm(int id) {
        HospitalFormDB hospitalFormDB = AdvancedWriter.getSession().get(HospitalFormDB.class, id);
        if (hospitalFormDB != null) {
            return hospitalFormDB;
        }
        JOptionPane.showMessageDialog(null, "No record with id = : " + id);
        return null;
    }

    @Override
    public Long countHospitalForms() {
        Query query = AdvancedWriter.getSession().createQuery("select count(id) from HospitalFormDB");

        Long id = (Long) query.uniqueResult();
        return id;
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
