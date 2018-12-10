package ro.uti.robert;

import com.primarie.model.CompanyForm;
import com.primarie.model.Form;
import com.primarie.model.HospitalForm;
import com.primarie.model.PoliceForm;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ro.uti.robert.mapper.*;
import ro.uti.robert.model.*;
import ro.uti.robert.repository.*;
import ro.uti.robert.repository.factory.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class AdvancedWriter {
    protected static Connection connection;
    protected static Properties databaseProperties;
    protected static Configuration configuration;

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

    /**
     * TODO: de utilizat API Hibernate pentru lucrul cu entitatile JPA (CRUD)
     * Se va renunta la Repository-uri facute manual
     * */

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

    private static SessionFactory sessionFactory;
    private static Session session;
    private static Transaction transaction;

    public static Form write(Form form) {
        setUp();
        sessionFactory = AdvancedWriter.getConfiguration().buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        if (form instanceof PoliceForm) {

            //COORDINATES -> COORDINATES ENTITY

            //save coordinates in the database
            coordinatesMapper = new CoordinatesMapper();
            CoordinatesDB coordinatesDB = coordinatesMapper.toCoordinatesDB(form.getLocation().getCoordinates());
            savedCoordinatesDB = coordinatesRepository.saveCoordinates(coordinatesDB);

            //APPLICANT ->ADDRESS ENTITY

            //save applicant address in the database
            addressMapper = new AddressMapper();
            AddressDB applicantAddressDB = addressMapper.toAddressDB(form.getApplicant().getAddress());
            savedApplicantAddressDB = addressRepository.saveAddress(applicantAddressDB);


            //LOCATION -> ADDRESS ENTITY

            //save location address object in the database
            addressMapper = new AddressMapper();
            AddressDB locationAddressDB = addressMapper.toAddressDB(form.getLocation().getAddress());
            savedLocationAddressDB = addressRepository.saveAddress(locationAddressDB);


            //INJURED PERSON -> ADDRESS ENTITY

            //save injured person address in the database
            addressMapper = new AddressMapper();
            AddressDB injuredPersonAddressDB = addressMapper.toAddressDB(((PoliceForm) form).getPerson().getAddress());
            savedInjuredPersonAddressDB = addressRepository.saveAddress(injuredPersonAddressDB);


            //AGENT -> ADDRESS ENTITY

            //save agent address in the database
            addressMapper = new AddressMapper();
            AddressDB agentAddressDB = addressMapper.toAddressDB(((PoliceForm) form).getAgent().getAddress());
            savedAgentAddressDB = addressRepository.saveAddress(agentAddressDB);


            //LOCATION -> LOCATION ENTITY

            //save location in the database
            locationMapper = new LocationMapper(locationAddressDB, coordinatesDB);
            LocationDB locationDB = locationMapper.toLocationDB(form.getLocation());
            savedLocationDB = locationRepository.saveLocation(locationDB, locationAddressDB, coordinatesDB);

            //APPLICANT -> PERSON ENTITY

            //save person applicant of type individual person in the database
            if (form.getApplicant().getIndividualPerson() != null) {

                IndividualPersonMapper individualPersonMapper = new IndividualPersonMapper();
                IndividualPersonDB applicantIndividualPersonDB = individualPersonMapper.toIndividualPersonDB(form.getApplicant().getIndividualPerson());
                savedApplicantIndividualPersonDB = individualPersonRepository.saveIndividualPerson(applicantIndividualPersonDB);

                PersonMapper personMapper = new PersonMapper(applicantIndividualPersonDB, individualPersonMapper,
                        null, null, applicantAddressDB, addressMapper);
                PersonDB applicantPersonDB = personMapper.toPersonDB(form.getApplicant());
                savedApplicantPerson = personRepository.savePerson(applicantPersonDB);

                //APPLICANT -> APPLICANT ENTITY

                //save applicant in the database
                applicantMapper = new ApplicantMapper();
                ApplicantDB applicantDB = applicantMapper.toApplicantDB(applicantPersonDB);
                savedApplicantDB = applicantRepository.saveApplicant(applicantDB);

            } else {

                //save applicant of type legal person in the database
                legalPersonMapper = new LegalPersonMapper();
                LegalPersonDB applicantLegalPersonDB = legalPersonMapper.toLegalPersonDB(form.getApplicant().getLegalPerson());
                savedApplicantLegalPersonDB = legalPersonRepository.saveLegalPerson(applicantLegalPersonDB);
                PersonMapper personMapper = new PersonMapper(null, null,
                        applicantLegalPersonDB, legalPersonMapper, applicantAddressDB, addressMapper);
                PersonDB applicantPersonDB = personMapper.toPersonDB(form.getApplicant());
                savedApplicantPerson = personRepository.savePerson(applicantPersonDB);

                //APPLICANT -> APPLICANT ENTITY

                //save applicant in the database
                applicantMapper = new ApplicantMapper();
                ApplicantDB applicantDB = applicantMapper.toApplicantDB(applicantPersonDB);
                savedApplicantDB = applicantRepository.saveApplicant(applicantDB);

            }

            //INJURED PERSON -> PERSON ENTITY

            //save injured person of type individual in the database
            if (((PoliceForm) form).getPerson().getIndividualPerson() != null) {
                individualPersonMapper = new IndividualPersonMapper();
                IndividualPersonDB injuredPersonIndividualPersonDB = individualPersonMapper.toIndividualPersonDB(((PoliceForm) form).getPerson().getIndividualPerson());
                savedInjuredPersonIndividualPersonDB = individualPersonRepository.saveIndividualPerson(injuredPersonIndividualPersonDB);


                //save person injured person in the database
                personMapper = new PersonMapper(injuredPersonIndividualPersonDB, individualPersonMapper,
                        null, null, injuredPersonAddressDB, addressMapper);
                PersonDB injuredPerson = personMapper.toPersonDB(((PoliceForm) form).getPerson());
                savedInjuredPerson = personRepository.savePerson(injuredPerson);


                //INJURED PERSON -> INJURED PERSON ENTITY

                //save injured person in the database
                injuredPersonMapper = new InjuredPersonMapper();
                InjuredPersonDB injuredPersonDB = injuredPersonMapper.toInjuredPersonDB(injuredPerson);
                savedInjuredPersonDB = injuredPersonRepository.saveInjuredPerson(injuredPersonDB);
            } else {

                //save injuredperson of type legal person in the database
                legalPersonMapper = new LegalPersonMapper();
                LegalPersonDB injuredLegalPersonDB = legalPersonMapper.toLegalPersonDB(((PoliceForm) form).getPerson().getLegalPerson());
                savedInjuredPersonLegalPersonDB = legalPersonRepository.saveLegalPerson(injuredLegalPersonDB);

                //save person injured person in the database
                personMapper = new PersonMapper(null, null,
                        injuredLegalPersonDB, legalPersonMapper, injuredPersonAddressDB, addressMapper);
                PersonDB injuredPerson = personMapper.toPersonDB(((PoliceForm) form).getPerson());
                savedInjuredPerson = personRepository.savePerson(injuredPerson);

                injuredPersonMapper = new InjuredPersonMapper();
                InjuredPersonDB injuredPersonDB = injuredPersonMapper.toInjuredPersonDB(injuredPerson);
                savedInjuredPersonDB = injuredPersonRepository.saveInjuredPerson(injuredPersonDB);

            }


            //AGENT -> PERSON ENTITY

            //save agent in the database
            individualPersonMapper = new IndividualPersonMapper();
            IndividualPersonDB agentPersonDB = individualPersonMapper.toIndividualPersonDB(((PoliceForm) form).getAgent().getIndividualPerson());
            savedAgentPersonDB = individualPersonRepository.saveIndividualPerson(agentPersonDB);

            personMapper = new PersonMapper(agentPersonDB, individualPersonMapper,
                    null, null, agentAddressDB, addressMapper);
            PersonDB agentPerson = personMapper.toPersonDB(((PoliceForm) form).getAgent());
            savedAgent = personRepository.savePerson(agentPerson);

            agentMapper = new AgentMapper();
            AgentDB agentDB = agentMapper.toAgentDB(agentPerson);
            savedAgentDB = agentRepository.saveAgent(agentDB);

            //POLICE FORM -> POLICE FORM ENTITY

            //save police form in the database
            policeFormMapper = new PoliceFormMapper(savedApplicantDB, applicantMapper, savedLocationDB, locationMapper,
                    savedInjuredPersonDB, injuredPersonMapper, savedAgentDB, agentMapper);
            PoliceFormDB policeFormDB = policeFormMapper.toPoliceFormDB(((PoliceForm) form));
            savedPoliceFormDB = policeFormRepository.savePoliceForm(policeFormDB);

            System.out.println("S-a inserat o inregistrare in tabela PoliceForm");

            coordinatesRepository.deleteCoordinates(1);
            transaction.commit();


            return form;

        }

        if (form instanceof HospitalForm) {

            //COORDINATES -> COORDINATES ENTITY

            //save coordinates in the database
            coordinatesMapper = new CoordinatesMapper();
            CoordinatesDB coordinatesDB = coordinatesMapper.toCoordinatesDB(form.getLocation().getCoordinates());
            savedCoordinatesDB = coordinatesRepository.saveCoordinates(coordinatesDB);

            //APPLICANT ->ADDRESS ENTITY

            //save applicant address in the database
            addressMapper = new AddressMapper();
            AddressDB applicantAddressDB = addressMapper.toAddressDB(form.getApplicant().getAddress());
            savedApplicantAddressDB = addressRepository.saveAddress(applicantAddressDB);

            //LOCATION -> ADDRESS ENTITY

            //save location address object in the database
            addressMapper = new AddressMapper();
            AddressDB locationAddressDB = addressMapper.toAddressDB(form.getLocation().getAddress());
            savedLocationAddressDB = addressRepository.saveAddress(locationAddressDB);

            //PACIENT PERSON -> ADDRESS ENTITY

            //save pacient person address in the database
            addressMapper = new AddressMapper();
            AddressDB pacientAddressDB = addressMapper.toAddressDB(((HospitalForm) form).getPerson().getAddress());
            savedPacientAddressDB = addressRepository.saveAddress(pacientAddressDB);

            //LOCATION -> LOCATION ENTITY

            //save location in the database
            locationMapper = new LocationMapper(locationAddressDB, coordinatesDB);
            LocationDB locationDB = locationMapper.toLocationDB(form.getLocation());
            savedLocationDB = locationRepository.saveLocation(locationDB, locationAddressDB, coordinatesDB);


            //APPLICANT -> PERSON ENTITY

            //save person applicant of type individual person in the database
            if (form.getApplicant().getIndividualPerson() != null) {
                IndividualPersonMapper individualPersonMapper = new IndividualPersonMapper();
                IndividualPersonDB applicantIndividualPersonDB = individualPersonMapper.toIndividualPersonDB(form.getApplicant().getIndividualPerson());
                savedApplicantIndividualPersonDB = individualPersonRepository.saveIndividualPerson(applicantIndividualPersonDB);

                PersonMapper personMapper = new PersonMapper(applicantIndividualPersonDB, individualPersonMapper,
                        null, null, applicantAddressDB, addressMapper);
                PersonDB applicantPersonDB = personMapper.toPersonDB(form.getApplicant());
                savedApplicantPerson = personRepository.savePerson(applicantPersonDB);

                //APPLICANT -> APPLICANT ENTITY

                //save applicant in the database
                applicantMapper = new ApplicantMapper();
                ApplicantDB applicantDB = applicantMapper.toApplicantDB(applicantPersonDB);
                savedApplicantDB = applicantRepository.saveApplicant(applicantDB);


            } else {
                //save applicant of type legal person in the database
                legalPersonMapper = new LegalPersonMapper();
                LegalPersonDB applicantLegalPersonDB = legalPersonMapper.toLegalPersonDB(form.getApplicant().getLegalPerson());
                savedApplicantLegalPersonDB = legalPersonRepository.saveLegalPerson(applicantLegalPersonDB);

                PersonMapper personMapper = new PersonMapper(null, null,
                        applicantLegalPersonDB, legalPersonMapper, applicantAddressDB, addressMapper);
                PersonDB applicantPersonDB = personMapper.toPersonDB(form.getApplicant());
                savedApplicantPerson = personRepository.savePerson(applicantPersonDB);


                //APPLICANT -> APPLICANT ENTITY

                //save applicant in the database
                applicantMapper = new ApplicantMapper();
                ApplicantDB applicantDB = applicantMapper.toApplicantDB(applicantPersonDB);
                savedApplicantDB = applicantRepository.saveApplicant(applicantDB);

            }

            //PACIENT PERSON -> PERSON ENTITY

            //save pacient person of type individual in the database
            individualPersonMapper = new IndividualPersonMapper();
            IndividualPersonDB pacientIndividualPersonDB = individualPersonMapper.toIndividualPersonDB(((HospitalForm) form).getPerson().getIndividualPerson());
            savedPacientIndividualPersonDB = individualPersonRepository.saveIndividualPerson(pacientIndividualPersonDB);

            //save person injured person in the database
            personMapper = new PersonMapper(savedPacientIndividualPersonDB, individualPersonMapper,
                    null, null, pacientAddressDB, addressMapper);
            PersonDB pacientPersonDB = personMapper.toPersonDB(((HospitalForm) form).getPerson());
            savedPacient = personRepository.savePerson(pacientPersonDB);

            //PACIENT PERSON -> PACIENT ENTITY
            pacientMapper = new PacientMapper();
            PacientDB pacientDB = pacientMapper.toPacientDB(savedPacient);
            savedPacientDB = pacientRepository.savePacientDB(pacientDB);

            //HOSPITAL FORM -> HOSPITAL FORM ENTITY

            //save hospital form in the database
            hospitalFormMapper = new HospitalFormMapper(savedApplicantDB, applicantMapper, savedLocationDB, locationMapper,
                    savedPacientDB, pacientMapper);
            HospitalFormDB hospitalFormDB = hospitalFormMapper.toHospitalFormDB(((HospitalForm) form));
            savedHospitalFormDB = hospitalFormRepository.saveHospitalForm(hospitalFormDB);
            System.out.println("S-a inserat o inregistrare in tabela HospitalForm");
            transaction.commit();
            return form;
        }

        if (form instanceof CompanyForm) {

            //COORDINATES -> COORDINATES ENTITY

            //save coordinates in the database
            coordinatesMapper = new CoordinatesMapper();
            CoordinatesDB coordinatesDB = coordinatesMapper.toCoordinatesDB(form.getLocation().getCoordinates());
            savedCoordinatesDB = coordinatesRepository.saveCoordinates(coordinatesDB);

            //APPLICANT ->ADDRESS ENTITY

            //save applicant address in the database
            addressMapper = new AddressMapper();
            AddressDB applicantAddressDB = addressMapper.toAddressDB(form.getApplicant().getAddress());
            savedApplicantAddressDB = addressRepository.saveAddress(applicantAddressDB);


            //LOCATION -> ADDRESS ENTITY

            //save location address object in the database
            addressMapper = new AddressMapper();
            AddressDB locationAddressDB = addressMapper.toAddressDB(form.getLocation().getAddress());
            savedLocationAddressDB = addressRepository.saveAddress(locationAddressDB);


            //LOCATION -> LOCATION ENTITY

            //save location in the database
            locationMapper = new LocationMapper(locationAddressDB, coordinatesDB);
            LocationDB locationDB = locationMapper.toLocationDB(form.getLocation());
            savedLocationDB = locationRepository.saveLocation(locationDB, locationAddressDB, coordinatesDB);


            //APPLICANT -> PERSON ENTITY

            //save person applicant of type individual person in the database
            if (form.getApplicant().getIndividualPerson() != null) {
                IndividualPersonMapper individualPersonMapper = new IndividualPersonMapper();
                IndividualPersonDB applicantIndividualPersonDB = individualPersonMapper.toIndividualPersonDB(form.getApplicant().getIndividualPerson());
                savedApplicantIndividualPersonDB = individualPersonRepository.saveIndividualPerson(applicantIndividualPersonDB);

                PersonMapper personMapper = new PersonMapper(applicantIndividualPersonDB, individualPersonMapper,
                        null, null, applicantAddressDB, addressMapper);
                PersonDB applicantPersonDB = personMapper.toPersonDB(form.getApplicant());
                savedApplicantPerson = personRepository.savePerson(applicantPersonDB);


                //APPLICANT -> APPLICANT ENTITY

                //save applicant in the database
                applicantMapper = new ApplicantMapper();
                ApplicantDB applicantDB = applicantMapper.toApplicantDB(applicantPersonDB);
                savedApplicantDB = applicantRepository.saveApplicant(applicantDB);


            } else {
                //save applicant of type legal person in the database
                legalPersonMapper = new LegalPersonMapper();
                LegalPersonDB applicantLegalPersonDB = legalPersonMapper.toLegalPersonDB(form.getApplicant().getLegalPerson());
                savedApplicantLegalPersonDB = legalPersonRepository.saveLegalPerson(applicantLegalPersonDB);

                PersonMapper personMapper = new PersonMapper(null, null,
                        applicantLegalPersonDB, legalPersonMapper, applicantAddressDB, addressMapper);
                PersonDB applicantPersonDB = personMapper.toPersonDB(form.getApplicant());
                savedApplicantPerson = personRepository.savePerson(applicantPersonDB);

                //APPLICANT -> APPLICANT ENTITY

                //save applicant in the database
                applicantMapper = new ApplicantMapper();
                ApplicantDB applicantDB = applicantMapper.toApplicantDB(applicantPersonDB);
                savedApplicantDB = applicantRepository.saveApplicant(applicantDB);

            }

            //COMPANY FORM -> COMPANY FORM ENTITY

            //save company form in the database
            companyFormMapper = new CompanyFormMapper(savedApplicantDB, applicantMapper, savedLocationDB, locationMapper);
            CompanyFormDB companyFormDB = companyFormMapper.toCompanyFormDB((CompanyForm) form);
            savedCompanyFormDB = companyFormRepository.saveCompanyForm(companyFormDB);
            System.out.println("S-a inserat o inregistrare in tabela CompanyForm");
            transaction.commit();
            return form;
        }


        return null;

    }

    public static void configure() {
        configuration = new Configuration().configure();
        configuration.addAnnotatedClass(CoordinatesDB.class);
        configuration.addAnnotatedClass(AddressDB.class);
        configuration.addAnnotatedClass(LocationDB.class);
        configuration.addAnnotatedClass(IndividualPersonDB.class);
        configuration.addAnnotatedClass(PersonDB.class);
        configuration.addAnnotatedClass(ApplicantDB.class);
        configuration.addAnnotatedClass(InjuredPersonDB.class);
        configuration.addAnnotatedClass(AgentDB.class);
        configuration.addAnnotatedClass(PacientDB.class);
        configuration.addAnnotatedClass(PoliceFormDB.class);
        configuration.addAnnotatedClass(HospitalFormDB.class);
        configuration.addAnnotatedClass(CompanyFormDB.class);

    }

    public static void setUp() {
        configure();
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

        coordinatesRepository = CoordinatesRepositoryFactory.getInstance();
        legalPersonRepository = LegalPersonRepositoryFactory.getInstance();
        individualPersonRepository = IndividualPersonRepositoryFactory.getInstance();
        addressRepository = AddressRepositoryFactory.getInstance();
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

    public static Configuration getConfiguration() {
        return configuration;
    }

    public static void setConfiguration(Configuration configuration) {
        AdvancedWriter.configuration = configuration;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        AdvancedWriter.connection = connection;
    }

    public static Properties getDatabaseProperties() {
        return databaseProperties;
    }

    public static void setDatabaseProperties(Properties databaseProperties) {
        AdvancedWriter.databaseProperties = databaseProperties;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        AdvancedWriter.sessionFactory = sessionFactory;
    }

    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        AdvancedWriter.session = session;
    }

    public static Transaction getTransaction() {
        return transaction;
    }

    public static void setTransaction(Transaction transaction) {
        AdvancedWriter.transaction = transaction;
    }
}
