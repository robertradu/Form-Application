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

    /**
     * Searches the id of the specified record of type {@link CompanyFormDB} exists
     *
     * @param companyFormDB
     * @return
     */
    Integer getCompanyFormId(CompanyFormDB personDB);
    //void deleteCompanyForm(int id);

    /**
     * Searches the specified record of type {@link CompanyFormDB}
     * @param id
     * @return
     */
    CompanyFormDB getCompanyForm(int id);

    /**
     * Counts all entities {@link CompanyFormDB} existent in DB
     * @return
     */
    Long countCompanyForms();
}
