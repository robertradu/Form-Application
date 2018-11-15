package ro.uti.robert.repository;

import ro.uti.robert.model.CompanyFormDB;

public interface CompanyFormRepository {
    /**
     * Creates or updates an entity of type {@link CompanyFormDB}.
     *
     * @param companyFormDB
     * @return: return the ID for created entity
     */
    CompanyFormDB saveCompanyForm(CompanyFormDB companyFormDB);
    //void deleteCompanyForm(int id);
}
