package ro.uti.robert.repository;

import ro.uti.robert.model.CompanyFormDB;

public interface CompanyFormRepository {
    CompanyFormDB saveCompanyForm(CompanyFormDB companyFormDB);
    void deleteCompanyForm(int id);
}
