package ro.uti.robert.repository.impl;

import org.hibernate.query.Query;
import ro.uti.robert.AdvancedWriter;
import ro.uti.robert.model.PoliceFormDB;
import ro.uti.robert.repository.PoliceFormRepository;

import javax.swing.*;

public class PoliceFormPostgresDBRepository implements PoliceFormRepository {

    public PoliceFormPostgresDBRepository() {
    }

    @Override
    public PoliceFormDB savePoliceForm(PoliceFormDB policeFormDB) {

        AdvancedWriter.getSession().save(policeFormDB);

        return policeFormDB;

    }

    @Override
    public Integer getPoliceFormId(PoliceFormDB policeFormDB) {
        Query query = AdvancedWriter.getSession().createQuery("select id from AddressDB " +
                " where applicantId = " + policeFormDB.getApplicantId()
                + " and details = '" + policeFormDB.getDetails() + "'"
                + " and authorizationNr = '" + policeFormDB.getAuthorizationNr() + "'"
                + " and locationId = " + policeFormDB.getLocationId()
                + " and injuredPersonId = " + policeFormDB.getInjuredPersonId()
                + " and agentId = " + policeFormDB.getAgentId()
                + " and recordDate = '" + policeFormDB.getRecordDate() + "'");

        Integer id = (Integer) query.uniqueResult();
        return id;
    }

    @Override
    public PoliceFormDB getPoliceForm(int id) {
        PoliceFormDB policeFormDB = AdvancedWriter.getSession().get(PoliceFormDB.class, id);

        if (policeFormDB != null) {
            return policeFormDB;
        }
        JOptionPane.showMessageDialog(null, "No record with id = : " + id);
        return null;
    }

    @Override
    public Long countPoliceForms() {
        Query query = AdvancedWriter.getSession().createQuery("select count(id) from PoliceFormDB");

        Long id = (Long) query.uniqueResult();
        return id;
    }

   /* @Override
    public void deletePoliceForm(int id) {

    }*/
}
