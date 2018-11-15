package ro.uti.robert.mapper;

import com.primarie.model.Person;
import ro.uti.robert.model.AddressDB;
import ro.uti.robert.model.IndividualPersonDB;
import ro.uti.robert.model.LegalPersonDB;
import ro.uti.robert.model.PersonDB;

public class PersonMapper {
    private PersonDB personDB;
    private Person person;
    private IndividualPersonDB individualPersonDB;
    private LegalPersonDB legalPersonDB;
    private AddressDB addressDB;
    private AddressMapper addressMapper;
    private LegalPersonMapper legalPersonMapper;
    private IndividualPersonMapper individualPersonMapper;

    public PersonMapper(IndividualPersonDB individualPersonDB, IndividualPersonMapper individualPersonMapper,
                        LegalPersonDB legalPersonDB, LegalPersonMapper legalPersonMapper,
                        AddressDB addressDB, AddressMapper addressMapper) {
        personDB = new PersonDB();
        person = new Person();
        this.individualPersonDB = individualPersonDB;
        this.individualPersonMapper = individualPersonMapper;
        this.legalPersonDB = legalPersonDB;
        this.legalPersonMapper = legalPersonMapper;
        this.addressDB = addressDB;
        this.addressMapper = addressMapper;
    }

    public PersonDB toPersonDB(Person person) {
        if (person.getLegalPerson() == null) {
            personDB.setLegalPersonId(null);
            personDB.setIndividualPersonId(individualPersonDB.getId());
            personDB.setTelephone(person.getTelephone());
            personDB.setAddressId(addressDB.getId());
        }
        if (person.getIndividualPerson() == null) {
            personDB.setIndividualPersonId(null);
            personDB.setLegalPersonId(legalPersonDB.getId());
            personDB.setAddressId(addressDB.getId());
            personDB.setTelephone(person.getTelephone());
        }
        return personDB;
    }

    public Person toPerson(Person person) {
        person.setAddress(addressMapper.toAddress(addressDB));
        person.setTelephone(personDB.getTelephone());
        person.setIndividualPerson(individualPersonMapper.toIndividualPerson(individualPersonDB));
        person.setLegalPerson(legalPersonMapper.toLegalPerson(legalPersonDB));
        return person;
    }


}
