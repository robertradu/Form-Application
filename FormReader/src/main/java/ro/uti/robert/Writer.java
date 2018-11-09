package ro.uti.robert;

import com.primarie.model.CompanyForm;
import com.primarie.model.Form;
import com.primarie.model.HospitalForm;
import com.primarie.model.PoliceForm;
import org.apache.ibatis.jdbc.ScriptRunner;
import ro.uti.robert.mapper.*;
import ro.uti.robert.model.*;
import ro.uti.robert.repository.*;
import ro.uti.robert.repository.factory.*;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Writer {


    public static Connection connection;
    public static Properties databaseProperties;


    private static LegalPersonRepository legalPersonRepository;
    private static IndividualPersonRepository individualPersonRepository;
    private static AddressRepository addressRepository;
    private static CoordinatesRepository coordinatesRepository;
    private static LocationRepository locationRepository;
    private static PersonRepository personRepository;
    private static ApplicantRepository applicantRepository;
    private static InjuredPersonRepository injuredPersonRepository;
    private static AgentRepository agentRepository;
    private static PoliceFormRepository policeFormRepository;
    private static PacientRepository pacientRepository;
    private static HospitalFormRepository hospitalFormRepository;
    private static CompanyFormRepository companyFormRepository;


    private static CoordinatesMapper coordinatesMapper;
    private static AddressMapper addressMapper;
    private static LocationMapper locationMapper;
    private static IndividualPersonMapper individualPersonMapper;
    private static LegalPersonMapper legalPersonMapper;
    private static PersonMapper personMapper;
    private static ApplicantMapper applicantMapper;
    private static InjuredPersonMapper injuredPersonMapper;
    private static AgentMapper agentMapper;
    private static PoliceFormMapper policeFormMapper;
    private static PacientMapper pacientMapper;
    private static HospitalFormMapper hospitalFormMapper;
    private static CompanyFormMapper companyFormMapper;


    private static CoordinatesDB savedCoordinatesDB;
    private static AddressDB savedApplicantAddressDB;
    private static AddressDB savedLocationAddressDB;
    private static AddressDB savedInjuredPersonAddressDB;
    private static AddressDB savedAgentAddressDB;
    private static AddressDB savedPacientAddressDB;
    private static LocationDB savedLocationDB;
    private static IndividualPersonDB savedApplicantIndividualPersonDB;
    private static IndividualPersonDB savedInjuredPersonIndividualPersonDB;
    private static IndividualPersonDB savedAgentPersonDB;
    private static IndividualPersonDB savedPacientIndividualPersonDB;
    private static LegalPersonDB savedApplicantLegalPersonDB;
    private static LegalPersonDB savedInjuredPersonLegalPerson;
    private static LegalPersonDB savedInjuredPersonLegalPersonDB;
    private static PersonDB savedApplicantPerson;
    private static PersonDB savedInjuredPerson;
    private static PersonDB savedAgent;
    private static PersonDB savedPacient;
    private static ApplicantDB savedApplicantDB;
    private static AgentDB savedAgentDB;
    private static InjuredPersonDB savedInjuredPersonDB;
    private static PacientDB savedPacientDB;
    private static PoliceFormDB savedPoliceFormDB;
    private static HospitalFormDB savedHospitalFormDB;
    private static CompanyFormDB savedCompanyFormDB;


    public static Form write(Form form) {

        setUp();
        if (form instanceof PoliceForm) {

            //COORDINATES -> COORDINATES ENTITY

            //save coordinates in the database
            coordinatesMapper = new CoordinatesMapper();
            CoordinatesDB coordinatesDB = coordinatesMapper.toCoordinatesDB(form.getLocation().getCoordinates());
            boolean coordinatesSaved = coordinatesRepository.checkForExistence(coordinatesDB);

            if (!coordinatesSaved) {
                savedCoordinatesDB = coordinatesRepository.saveCoordinates(coordinatesDB);
            }
            //APPLICANT ->ADDRESS ENTITY

            //save applicant address in the database
            addressMapper = new AddressMapper();
            AddressDB applicantAddressDB = addressMapper.toAddressDB(form.getApplicant().getAddress());
            boolean applicantAddressSaved = addressRepository.checkForExistence(applicantAddressDB);

            if (!applicantAddressSaved)
                savedApplicantAddressDB = addressRepository.saveAddress(applicantAddressDB);


            //LOCATION -> ADDRESS ENTITY

            //save location address object in the database
            addressMapper = new AddressMapper();
            AddressDB locationAddressDB = addressMapper.toAddressDB(form.getLocation().getAddress());
            boolean locationAddressSaved = addressRepository.checkForExistence(locationAddressDB);

            if (!locationAddressSaved)
                savedLocationAddressDB = addressRepository.saveAddress(locationAddressDB);

            //INJURED PERSON -> ADDRESS ENTITY

            //save injured person address in the database
            addressMapper = new AddressMapper();
            AddressDB injuredPersonAddressDB = addressMapper.toAddressDB(((PoliceForm) form).getPerson().getAddress());
            boolean injuredPersonAddressSaved = addressRepository.checkForExistence(injuredPersonAddressDB);

            if (!injuredPersonAddressSaved)
                savedInjuredPersonAddressDB = addressRepository.saveAddress(injuredPersonAddressDB);

            //AGENT -> ADDRESS ENTITY

            //save agent address in the database
            addressMapper = new AddressMapper();
            AddressDB agentAddressDB = addressMapper.toAddressDB(((PoliceForm) form).getAgent().getAddress());
            boolean agentAddressSaved = addressRepository.checkForExistence(agentAddressDB);

            if (!agentAddressSaved)
                savedAgentAddressDB = addressRepository.saveAddress(agentAddressDB);


            //LOCATION -> LOCATION ENTITY

            //save location in the database
            locationMapper = new LocationMapper(savedLocationAddressDB, savedCoordinatesDB);
            LocationDB locationDB = locationMapper.toLocationDB(form.getLocation());
            boolean locationSaved = locationRepository.checkForExistence(locationDB);

            if (!locationSaved)
                savedLocationDB = locationRepository.saveLocation(locationDB, savedLocationAddressDB, savedCoordinatesDB);


            //APPLICANT -> PERSON ENTITY

            //save person applicant of type individual person in the database
            if (form.getApplicant().getIndividualPerson() != null) {
                individualPersonMapper = new IndividualPersonMapper();
                IndividualPersonDB applicantIndividualPersonDB = individualPersonMapper.toIndividualPersonDB(form.getApplicant().getIndividualPerson());
                boolean applicantIndividualPersonSaved = individualPersonRepository.checkForExistence(applicantIndividualPersonDB);

                if (!applicantIndividualPersonSaved) {
                    savedApplicantIndividualPersonDB = individualPersonRepository.saveIndividualPerson(applicantIndividualPersonDB);
                    //save person applicant in the database
                    personMapper = new PersonMapper(savedApplicantIndividualPersonDB, individualPersonMapper,
                            null, null, savedApplicantAddressDB, addressMapper);
                    PersonDB applicantPerson = personMapper.toPersonDB(form.getApplicant());
                    boolean applicantPersonSaved = personRepository.checkForExistence(applicantPerson);

                    if (!applicantPersonSaved)
                        savedApplicantPerson = personRepository.savePerson(applicantPerson);


                    //APPLICANT -> APPLICANT ENTITY
                    applicantMapper = new ApplicantMapper();
                    ApplicantDB applicantDB = applicantMapper.toApplicantDB(savedApplicantPerson);
                    boolean applicantDBSaved = applicantRepository.checkForExistence(applicantDB);

                    if (!applicantDBSaved)
                        savedApplicantDB = applicantRepository.saveApplicant(applicantDB);


                }

            } else {
                //save applicant of type legal person in the database
                legalPersonMapper = new LegalPersonMapper();
                LegalPersonDB applicantLegalPersonDB = legalPersonMapper.toLegalPersonDB(form.getApplicant().getLegalPerson());
                boolean applicantLegalPersonSaved = legalPersonRepository.checkForExistence(applicantLegalPersonDB);

                if (!applicantLegalPersonSaved) {
                    savedApplicantLegalPersonDB = legalPersonRepository.saveLegalPerson(applicantLegalPersonDB);

                    //save person applicant in the database
                    personMapper = new PersonMapper(null, null,
                            savedApplicantLegalPersonDB, legalPersonMapper, savedApplicantAddressDB, addressMapper);
                    PersonDB applicantPerson = personMapper.toPersonDB(form.getApplicant());
                    boolean applicantPersonSaved = personRepository.checkForExistence(applicantPerson);

                    if (!applicantPersonSaved)
                        savedApplicantPerson = personRepository.savePerson(applicantPerson);

                    //APPLICANT -> APPLICANT ENTITY
                    applicantMapper = new ApplicantMapper();
                    ApplicantDB applicantDB = applicantMapper.toApplicantDB(savedApplicantPerson);
                    boolean applicantDBSaved = applicantRepository.checkForExistence(applicantDB);

                    if (!applicantDBSaved)
                        savedApplicantDB = applicantRepository.saveApplicant(applicantDB);

                }
            }

            //INJURED PERSON -> PERSON ENTITY

            //save injured person of type individual in the database
            if (((PoliceForm) form).getPerson().getIndividualPerson() != null) {
                individualPersonMapper = new IndividualPersonMapper();
                IndividualPersonDB injuredPersonIndividualPersonDB = individualPersonMapper.toIndividualPersonDB(((PoliceForm) form).getPerson().getIndividualPerson());
                boolean injuredPersonIndividualPersonSaved = individualPersonRepository.checkForExistence(injuredPersonIndividualPersonDB);

                if (!injuredPersonIndividualPersonSaved) {
                    savedInjuredPersonIndividualPersonDB = individualPersonRepository.saveIndividualPerson(injuredPersonIndividualPersonDB);

                    //save person injured person in the database
                    personMapper = new PersonMapper(savedInjuredPersonIndividualPersonDB, individualPersonMapper,
                            null, null, savedInjuredPersonAddressDB, addressMapper);
                    PersonDB injuredPerson = personMapper.toPersonDB(((PoliceForm) form).getPerson());
                    boolean injuredPersonSaved = personRepository.checkForExistence(injuredPerson);

                    if (!injuredPersonSaved)
                        savedInjuredPerson = personRepository.savePerson(injuredPerson);

                    //INJURED PERSON -> INJURED PERSON ENTITY
                    injuredPersonMapper = new InjuredPersonMapper();
                    InjuredPersonDB injuredPersonDB = injuredPersonMapper.toInjuredPersonDB(savedInjuredPerson);
                    boolean injuredPersonDBSaved = injuredPersonRepository.checkForExistence(injuredPersonDB);

                    if (!injuredPersonDBSaved)
                        savedInjuredPersonDB = injuredPersonRepository.saveInjuredPerson(injuredPersonDB);
                }
            } else {
                //save injuredperson of type legal person in the database
                legalPersonMapper = new LegalPersonMapper();
                LegalPersonDB injuredPersonLegalPerson = legalPersonMapper.toLegalPersonDB(((PoliceForm) form).getPerson().getLegalPerson());
                boolean injuredPersonLegalPersonSaved = legalPersonRepository.checkForExistence(injuredPersonLegalPerson);

                if (!injuredPersonLegalPersonSaved) {
                    savedInjuredPersonLegalPersonDB = legalPersonRepository.saveLegalPerson(injuredPersonLegalPerson);

                    //save person applicant in the database
                    personMapper = new PersonMapper(null, null,
                            savedInjuredPersonLegalPerson, legalPersonMapper, savedInjuredPersonAddressDB, addressMapper);
                    PersonDB injuredPerson = personMapper.toPersonDB(((PoliceForm) form).getPerson());
                    boolean injuredPersonSaved = personRepository.checkForExistence(injuredPerson);

                    if (!injuredPersonSaved)
                        savedInjuredPerson = personRepository.savePerson(injuredPerson);

                    //INJURED PERSON -> INJURED PERSON ENTITY
                    injuredPersonMapper = new InjuredPersonMapper();
                    InjuredPersonDB injuredPersonDB = injuredPersonMapper.toInjuredPersonDB(savedInjuredPerson);
                    boolean injuredPersonDBSaved = injuredPersonRepository.checkForExistence(injuredPersonDB);

                    if (!injuredPersonDBSaved)
                        savedInjuredPersonDB = injuredPersonRepository.saveInjuredPerson(injuredPersonDB);

                }
            }

            //AGENT -> PERSON ENTITY

            //save agent in the database
            if (((PoliceForm) form).getAgent().getIndividualPerson() != null) {
                individualPersonMapper = new IndividualPersonMapper();
                IndividualPersonDB agentPersonDB = individualPersonMapper.toIndividualPersonDB(((PoliceForm) form).getAgent().getIndividualPerson());
                boolean agentSaved = individualPersonRepository.checkForExistence(agentPersonDB);

                if (!agentSaved) {
                    savedAgentPersonDB = individualPersonRepository.saveIndividualPerson(agentPersonDB);

                    personMapper = new PersonMapper(savedAgentPersonDB, individualPersonMapper,
                            null, null, savedAgentAddressDB, addressMapper);
                    PersonDB agentPerson = personMapper.toPersonDB(form.getApplicant());
                    boolean agentPersonSaved = personRepository.checkForExistence(agentPerson);

                    if (!agentPersonSaved)
                        savedAgent = personRepository.savePerson(agentPerson);

                    //AGENT -> AGENT ENTITY
                    agentMapper = new AgentMapper();
                    AgentDB agentDB = agentMapper.toAgentDB(savedAgent);
                    boolean agentDBSaved = agentRepository.checkForExistence(agentDB);

                    if (!agentDBSaved)
                        savedAgentDB = agentRepository.saveAgent(agentDB);

                }
            }

                   /* applicantMapper = new ApplicantMapper();
                    locationMapper = new LocationMapper(savedAgentAddressDB, savedCoordinatesDB);
                    injuredPersonMapper = new InjuredPersonMapper();
                    agentMapper = new AgentMapper();*/
            policeFormMapper = new PoliceFormMapper(savedApplicantDB, applicantMapper, savedLocationDB, locationMapper,
                    savedInjuredPersonDB, injuredPersonMapper, savedAgentDB, agentMapper);
            PoliceFormDB policeFormDB = policeFormMapper.toPoliceFormDB(((PoliceForm) form));
            savedPoliceFormDB = policeFormRepository.savePoliceForm(policeFormDB);
            System.out.println("S-a inserat o inregistrare in tabela PoliceForm");


            return form;

        }

        if (form instanceof HospitalForm) {
            //COORDINATES -> COORDINATES ENTITY

            //save coordinates in the database
            coordinatesMapper = new CoordinatesMapper();
            CoordinatesDB coordinatesDB = coordinatesMapper.toCoordinatesDB(form.getLocation().getCoordinates());
            boolean coordinatesSaved = coordinatesRepository.checkForExistence(coordinatesDB);

            if (!coordinatesSaved)
                savedCoordinatesDB = coordinatesRepository.saveCoordinates(coordinatesDB);

            //APPLICANT ->ADDRESS ENTITY

            //save applicant address in the database
            addressMapper = new AddressMapper();
            AddressDB applicantAddressDB = addressMapper.toAddressDB(form.getApplicant().getAddress());
            boolean applicantAddressSaved = addressRepository.checkForExistence(applicantAddressDB);

            if (!applicantAddressSaved)
                savedApplicantAddressDB = addressRepository.saveAddress(applicantAddressDB);


            //LOCATION -> ADDRESS ENTITY

            //save location address object in the database
            addressMapper = new AddressMapper();
            AddressDB locationAddressDB = addressMapper.toAddressDB(form.getLocation().getAddress());
            boolean locationAddressSaved = addressRepository.checkForExistence(locationAddressDB);

            if (!locationAddressSaved)
                savedLocationAddressDB = addressRepository.saveAddress(locationAddressDB);


            //PACIENT PERSON -> ADDRESS ENTITY

            //save pacient person address in the database
            addressMapper = new AddressMapper();
            AddressDB pacientAddressDB = addressMapper.toAddressDB(((HospitalForm) form).getPerson().getAddress());
            boolean pacientAddressSaved = addressRepository.checkForExistence(pacientAddressDB);

            if (!pacientAddressSaved)
                savedPacientAddressDB = addressRepository.saveAddress(pacientAddressDB);


            //LOCATION -> LOCATION ENTITY

            //save location in the database
            locationMapper = new LocationMapper(savedLocationAddressDB, savedCoordinatesDB);
            LocationDB locationDB = locationMapper.toLocationDB(form.getLocation());
            boolean locationSaved = locationRepository.checkForExistence(locationDB);

            if (!locationSaved)
                savedLocationDB = locationRepository.saveLocation(locationDB, savedLocationAddressDB, savedCoordinatesDB);


            //APPLICANT -> PERSON ENTITY

            //save person applicant of type individual person in the database
            if (form.getApplicant().getIndividualPerson() != null) {
                individualPersonMapper = new IndividualPersonMapper();
                IndividualPersonDB applicantIndividualPersonDB = individualPersonMapper.toIndividualPersonDB(form.getApplicant().getIndividualPerson());
                boolean applicantIndividualPersonSaved = individualPersonRepository.checkForExistence(applicantIndividualPersonDB);

                if (!applicantIndividualPersonSaved) {
                    savedApplicantIndividualPersonDB = individualPersonRepository.saveIndividualPerson(applicantIndividualPersonDB);

                    //save person applicant in the database
                    personMapper = new PersonMapper(savedApplicantIndividualPersonDB, individualPersonMapper,
                            null, null, savedApplicantAddressDB, addressMapper);
                    PersonDB applicantPerson = personMapper.toPersonDB(form.getApplicant());
                    boolean applicantPersonSaved = personRepository.checkForExistence(applicantPerson);

                    if (!applicantPersonSaved)
                        savedApplicantPerson = personRepository.savePerson(applicantPerson);


                    //APPLICANT -> APPLICANT ENTITY
                    applicantMapper = new ApplicantMapper();
                    ApplicantDB applicantDB = applicantMapper.toApplicantDB(savedApplicantPerson);
                    boolean applicantDBSaved = applicantRepository.checkForExistence(applicantDB);

                    if (!applicantDBSaved)
                        savedApplicantDB = applicantRepository.saveApplicant(applicantDB);

                }
            } else {
                //save applicant of type legal person in the database
                legalPersonMapper = new LegalPersonMapper();
                LegalPersonDB applicantLegalPersonDB = legalPersonMapper.toLegalPersonDB(form.getApplicant().getLegalPerson());
                boolean applicantLegalPersonSaved = legalPersonRepository.checkForExistence(applicantLegalPersonDB);

                if (!applicantLegalPersonSaved) {
                    savedApplicantLegalPersonDB = legalPersonRepository.saveLegalPerson(applicantLegalPersonDB);

                    //save person applicant in the database
                    personMapper = new PersonMapper(null, null,
                            savedApplicantLegalPersonDB, legalPersonMapper, savedApplicantAddressDB, addressMapper);
                    PersonDB applicantPerson = personMapper.toPersonDB(form.getApplicant());
                    boolean applicantPersonSaved = personRepository.checkForExistence(applicantPerson);

                    if (!applicantPersonSaved)
                        savedApplicantPerson = personRepository.savePerson(applicantPerson);

                    //APPLICANT -> APPLICANT ENTITY
                    applicantMapper = new ApplicantMapper();
                    ApplicantDB applicantDB = applicantMapper.toApplicantDB(savedApplicantPerson);
                    boolean applicantDBSaved = applicantRepository.checkForExistence(applicantDB);

                    if (!applicantDBSaved)
                        savedApplicantDB = applicantRepository.saveApplicant(applicantDB);

                }
            }
            //PACIENT PERSON -> PERSON ENTITY

            //save pacient person of type individual in the database
            if (((HospitalForm) form).getPerson().getIndividualPerson() != null) {
                individualPersonMapper = new IndividualPersonMapper();
                IndividualPersonDB pacientIndividualPersonDB = individualPersonMapper.toIndividualPersonDB(((HospitalForm) form).getPerson().getIndividualPerson());
                boolean pacientIndividualPersonSaved = individualPersonRepository.checkForExistence(pacientIndividualPersonDB);

                if (!pacientIndividualPersonSaved) {
                    savedPacientIndividualPersonDB = individualPersonRepository.saveIndividualPerson(pacientIndividualPersonDB);

                    //save pacient person in the database
                    personMapper = new PersonMapper(savedPacientIndividualPersonDB, individualPersonMapper,
                            null, null, savedPacientAddressDB, addressMapper);
                    PersonDB pacientPerson = personMapper.toPersonDB(((HospitalForm) form).getPerson());
                    boolean pacientSaved = personRepository.checkForExistence(pacientPerson);

                    if (!pacientSaved)
                        savedPacient = personRepository.savePerson(pacientPerson);

                    //PACIENT PERSON -> PACIENT ENTITY
                    pacientMapper = new PacientMapper();
                    PacientDB pacientDB = pacientMapper.toPacientDB(savedPacient);
                    boolean pacientDBSaved = pacientRepository.checkForExistence(pacientDB);

                    if (!pacientDBSaved)
                        savedPacientDB = pacientRepository.savePacientDB(pacientDB);

                }
            }

                    /* applicantMapper = new ApplicantMapper();
                    locationMapper = new LocationMapper(savedAgentAddressDB, savedCoordinatesDB);
                    injuredPersonMapper = new InjuredPersonMapper();
                    agentMapper = new AgentMapper();*/
            hospitalFormMapper = new HospitalFormMapper(savedApplicantDB, applicantMapper, savedLocationDB, locationMapper,
                    savedPacientDB, pacientMapper);
            HospitalFormDB hospitalFormDB = hospitalFormMapper.toHospitalFormDB(((HospitalForm) form));
            savedHospitalFormDB = hospitalFormRepository.saveHospitalForm(hospitalFormDB);
            System.out.println("S-a inserat o inregistrare in tabela HospitalForm");

            return form;
        }

        if (form instanceof CompanyForm) {
            //COORDINATES -> COORDINATES ENTITY

            //save coordinates in the database
            coordinatesMapper = new CoordinatesMapper();
            CoordinatesDB coordinatesDB = coordinatesMapper.toCoordinatesDB(form.getLocation().getCoordinates());
            boolean coordinatesSaved = coordinatesRepository.checkForExistence(coordinatesDB);

            if (!coordinatesSaved)
                savedCoordinatesDB = coordinatesRepository.saveCoordinates(coordinatesDB);

            //APPLICANT ->ADDRESS ENTITY

            //save applicant address in the database
            addressMapper = new AddressMapper();
            AddressDB applicantAddressDB = addressMapper.toAddressDB(form.getApplicant().getAddress());
            boolean applicantAddressSaved = addressRepository.checkForExistence(applicantAddressDB);

            if (!applicantAddressSaved)
                savedApplicantAddressDB = addressRepository.saveAddress(applicantAddressDB);


            //LOCATION -> ADDRESS ENTITY

            //save location address object in the database
            addressMapper = new AddressMapper();
            AddressDB locationAddressDB = addressMapper.toAddressDB(form.getLocation().getAddress());
            boolean locationAddressSaved = addressRepository.checkForExistence(locationAddressDB);

            if (!locationAddressSaved)
                savedLocationAddressDB = addressRepository.saveAddress(locationAddressDB);


            //LOCATION -> LOCATION ENTITY

            //save location in the database
            locationMapper = new LocationMapper(savedLocationAddressDB, savedCoordinatesDB);
            LocationDB locationDB = locationMapper.toLocationDB(form.getLocation());
            boolean locationSaved = locationRepository.checkForExistence(locationDB);

            if (!locationSaved)
                savedLocationDB = locationRepository.saveLocation(locationDB, savedLocationAddressDB, savedCoordinatesDB);


            //APPLICANT -> PERSON ENTITY

            //save person applicant of type individual person in the database
            if (form.getApplicant().getIndividualPerson() != null) {
                individualPersonMapper = new IndividualPersonMapper();
                IndividualPersonDB applicantIndividualPersonDB = individualPersonMapper.toIndividualPersonDB(form.getApplicant().getIndividualPerson());
                boolean applicantIndividualPersonSaved = individualPersonRepository.checkForExistence(applicantIndividualPersonDB);

                if (!applicantIndividualPersonSaved) {
                    savedApplicantIndividualPersonDB = individualPersonRepository.saveIndividualPerson(applicantIndividualPersonDB);

                    //save person applicant in the database
                    personMapper = new PersonMapper(savedApplicantIndividualPersonDB, individualPersonMapper,
                            null, null, savedApplicantAddressDB, addressMapper);
                    PersonDB applicantPerson = personMapper.toPersonDB(form.getApplicant());
                    boolean applicantPersonSaved = personRepository.checkForExistence(applicantPerson);

                    if (!applicantPersonSaved)
                        savedApplicantPerson = personRepository.savePerson(applicantPerson);


                    //APPLICANT -> APPLICANT ENTITY
                    applicantMapper = new ApplicantMapper();
                    ApplicantDB applicantDB = applicantMapper.toApplicantDB(savedApplicantPerson);
                    boolean applicantDBSaved = applicantRepository.checkForExistence(applicantDB);

                    if (!applicantDBSaved)
                        savedApplicantDB = applicantRepository.saveApplicant(applicantDB);

                }
            } else {
                //save applicant of type legal person in the database
                legalPersonMapper = new LegalPersonMapper();
                LegalPersonDB applicantLegalPersonDB = legalPersonMapper.toLegalPersonDB(form.getApplicant().getLegalPerson());
                boolean applicantLegalPersonSaved = legalPersonRepository.checkForExistence(applicantLegalPersonDB);

                if (!applicantLegalPersonSaved) {
                    savedApplicantLegalPersonDB = legalPersonRepository.saveLegalPerson(applicantLegalPersonDB);

                    //save person applicant in the database
                    personMapper = new PersonMapper(null, null,
                            savedApplicantLegalPersonDB, legalPersonMapper, savedApplicantAddressDB, addressMapper);
                    PersonDB applicantPerson = personMapper.toPersonDB(form.getApplicant());
                    boolean applicantPersonSaved = personRepository.checkForExistence(applicantPerson);

                    if (!applicantPersonSaved)
                        savedApplicantPerson = personRepository.savePerson(applicantPerson);

                    //APPLICANT -> APPLICANT ENTITY
                    applicantMapper = new ApplicantMapper();
                    ApplicantDB applicantDB = applicantMapper.toApplicantDB(savedApplicantPerson);
                    boolean applicantDBSaved = applicantRepository.checkForExistence(applicantDB);

                    if (!applicantDBSaved)
                        savedApplicantDB = applicantRepository.saveApplicant(applicantDB);

                }
            }

                 /* applicantMapper = new ApplicantMapper();
                    locationMapper = new LocationMapper(savedAgentAddressDB, savedCoordinatesDB);
                    injuredPersonMapper = new InjuredPersonMapper();
                    agentMapper = new AgentMapper();*/
            companyFormMapper = new CompanyFormMapper(savedApplicantDB, applicantMapper, savedLocationDB, locationMapper);
            CompanyFormDB companyFormDB = companyFormMapper.toCompanyFormDB((CompanyForm) form);
            savedCompanyFormDB = companyFormRepository.saveCompanyForm(companyFormDB);

            System.out.println("S-a inserat o inregistrare in tabela CompanyForm");
            return form;
        }


        return null;

    }


    public static void initDB() {
        ScriptRunner scriptRunner = new ScriptRunner(connection);
        try {
            Reader reader = new BufferedReader(new FileReader("C:\\Users\\robert.radu\\IdeaProjects\\FormReader\\src\\main\\resources\\scripts\\init_db.sql"));
            scriptRunner.runScript(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void setUp() {
        connect();
       // initDB();


        try {

            databaseProperties = new Properties();
            databaseProperties.setProperty("database_type", "POSTGRESQL");
            File file = new File("C:\\Users\\robert.radu\\IdeaProjects\\FormReader\\src\\main\\resources\\application.properties");
            FileOutputStream fo = new FileOutputStream(file);

            databaseProperties.store(fo, "Database type : ");
            fo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        legalPersonRepository = LegalPersonRepositoryFactory.getInstance();
        individualPersonRepository = IndividualPersonRepositoryFactory.getInstance();
        addressRepository = AddressRepositoryFactory.getInstance();
        coordinatesRepository = CoordinatesRepositoryFactory.getInstance();
        locationRepository = LocationRepositoryFactory.getInstance();
        personRepository = PersonRepositoryFactory.getInstance();
        applicantRepository = ApplicantRepositoryFactory.getInstance();
        injuredPersonRepository = InjuredPersonRepositoryFactory.getInstance();
        agentRepository = AgentRepositoryFactory.getInstance();
        policeFormRepository = PoliceFormRepositoryFactory.getInstance();
        pacientRepository = PacientRepositoryFactory.getInstance();
        hospitalFormRepository = HospitalFormRepositoryFactory.getInstance();
        companyFormRepository = CompanyFormRepositoryFactory.getInstance();





    }

    public static void connect() {
        try {
            String url = "jdbc:postgresql://localhost:5433/postgres";
            String user = "postgres";
            String password = "admin";
            connection = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
