package ro.uti.robert.repository.impl;

import org.hibernate.query.Query;
import ro.uti.robert.AdvancedWriter;
import ro.uti.robert.model.CompanyFormDB;
import ro.uti.robert.repository.CompanyFormRepository;

public class CompanyFormDBRepository implements CompanyFormRepository {

    public CompanyFormDBRepository() {
    }


    @Override
    public CompanyFormDB saveCompanyForm(CompanyFormDB companyFormDB) {
        Query query = AdvancedWriter.getSession().createQuery("select id from CompanyFormDB " +
                " where applicantId = " + companyFormDB.getApplicantId()
                + " and details = '" + companyFormDB.getDetails() + "'"
                + " and locationId = " + companyFormDB.getLocationId()
                + " and contractNr = '" + companyFormDB.getContractNr() + "'"
                + " and recordDate = '" + companyFormDB.getRecordDate() + "'");

        AdvancedWriter.getSession().save(companyFormDB);

        return companyFormDB;
    }

   /* @Override
    public void deleteCompanyForm(int id) {

    }*/
}
