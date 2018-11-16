package ro.uti.robert.repository.impl;

import org.hibernate.query.Query;
import ro.uti.robert.AdvancedWriter;
import ro.uti.robert.model.CompanyFormDB;
import ro.uti.robert.repository.CompanyFormRepository;

import javax.swing.*;

public class CompanyFormPostgresDBRepository implements CompanyFormRepository {

    public CompanyFormPostgresDBRepository() {
    }


    @Override
    public CompanyFormDB saveCompanyForm(CompanyFormDB companyFormDB) {

        AdvancedWriter.getSession().save(companyFormDB);

        return companyFormDB;
    }

    @Override
    public Integer getCompanyFormId(CompanyFormDB companyFormDB) {
        Query query = AdvancedWriter.getSession().createQuery("select id from CompanyFormDB " +
                " where applicantId = " + companyFormDB.getApplicantId()
                + " and details = '" + companyFormDB.getDetails() + "'"
                + " and locationId = " + companyFormDB.getLocationId()
                + " and contractNr = '" + companyFormDB.getContractNr() + "'"
                + " and recordDate = '" + companyFormDB.getRecordDate() + "'");

        Integer id = (Integer) query.uniqueResult();
        return id;
    }

    @Override
    public CompanyFormDB getCompanyForm(int id) {
        CompanyFormDB companyFormDB = AdvancedWriter.getSession().get(CompanyFormDB.class, id);
        if (companyFormDB != null) {
            return companyFormDB;
        }
        JOptionPane.showMessageDialog(null, "No record with id = : " + id);
        return null;
    }

    @Override
    public Long countCompanyForms() {
        Query query = AdvancedWriter.getSession().createQuery("select count(id) from CompanyFormDB");

        Long id = (Long) query.uniqueResult();
        return id;
    }

   /* @Override
    public void deleteCompanyForm(int id) {

    }*/
}
