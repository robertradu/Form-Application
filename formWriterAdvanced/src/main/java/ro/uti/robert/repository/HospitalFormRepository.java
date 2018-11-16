package ro.uti.robert.repository;

import ro.uti.robert.model.HospitalFormDB;

public interface HospitalFormRepository {

    /**
     * Creates or updates an entity of type {@link HospitalFormDB}.
     *
     * @param hospitalFormDB
     * @return: return the ID for created entity
     */
    HospitalFormDB saveHospitalForm(HospitalFormDB hospitalForm);

    /**
     * Searches the id of the specified record of type {@link HospitalFormDB} exists
     *
     * @param hospitalFormDB
     * @return
     */
    Integer getHospitalFormId(HospitalFormDB personDB);

    /**
     * Searches the specified record of type {@link HospitalFormDB}
     *
     * @param id
     * @return
     */
    HospitalFormDB getHospitalForm(int id);

    /**
     *
     * @param id
     */
    //void deleteHospitalForm(Long id);

    /**
     * Counts all entities {@link HospitalFormDB} existent in DB
     * @return
     */
    Long countHospitalForms();

}
