package ro.uti.robert.repository.impl;

import org.hibernate.query.Query;
import ro.uti.robert.AdvancedWriter;
import ro.uti.robert.model.PoliceFormDB;
import ro.uti.robert.repository.PoliceFormRepository;

public class PoliceFormDBRepository implements PoliceFormRepository {

    public PoliceFormDBRepository() {
    }

    @Override
    public PoliceFormDB savePoliceForm(PoliceFormDB policeFormDB) {
        Query query = AdvancedWriter.getSession().createQuery("select id from AddressDB " +
                " where applicantId = " + policeFormDB.getApplicantId()
                + " and details = '" + policeFormDB.getDetails() + "'"
                + " and authorizationNr = '" + policeFormDB.getAuthorizationNr() + "'"
                + " and locationId = " + policeFormDB.getLocationId()
                + " and injuredPersonId = " + policeFormDB.getInjuredPersonId()
                + " and agentId = " + policeFormDB.getAgentId()
                + " and recordDate = '" + policeFormDB.getRecordDate() + "'");

        AdvancedWriter.getSession().save(policeFormDB);

        return policeFormDB;

    }

   /* @Override
    public void deletePoliceForm(int id) {

    }*/
}
