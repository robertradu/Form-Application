package ro.uti.robert.repository;

import ro.uti.robert.model.HospitalFormDB;

public interface HospitalFormRepository {

    /**
     * Creates or updates an entity of type {@link HospitalFormDB}.
     *
     * @param hospitalForm
     * @return: return the ID for created entity
     */
    HospitalFormDB saveHospitalForm(HospitalFormDB hospitalForm);

    HospitalFormDB getHospitalForm(Long id);

    /**
     *
     * @param id
     */
    void deleteHospitalForm(Long id);

    /**
     * Counts all entities {@link HospitalFormDB} existent in DB
     * @return
     */
    Long countHospitalForms();

}
