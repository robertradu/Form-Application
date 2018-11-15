package ro.uti.robert.repository.impl;

import com.primarie.model.Person;
import org.hibernate.query.Query;
import ro.uti.robert.AdvancedWriter;
import ro.uti.robert.model.LegalPersonDB;
import ro.uti.robert.repository.LegalPersonRepository;

public class LegalPersonDBRepository implements LegalPersonRepository {
    private LegalPersonDB legalPersonDB;
    private Person person;

    public void setUp() {
        AdvancedWriter.connect();
    }

    public LegalPersonDBRepository() {
        setUp();
    }

    @Override
    public LegalPersonDB saveLegalPerson(LegalPersonDB legalPersonDB) {
        Query query = AdvancedWriter.getSession().createQuery("select id from LegalPersonDB " +
                " where name = '" + legalPersonDB.getName() + "'"
                + " and cif = '" + legalPersonDB.getCif() + "'");


        Integer id = (Integer) query.uniqueResult();
        if (id == null) {
            AdvancedWriter.getSession().save(legalPersonDB);
        } else {
            legalPersonDB.setId(id);
        }
        return legalPersonDB;
    }

   /* @Override
    public boolean checkForExistence(LegalPersonDB legalPersonDB) {
        try {
            PreparedStatement preparedStatement = AdvancedWriter.getConnection().prepareStatement(
                    "SELECT * FROM validated_forms.legalperson where cif = " + legalPersonDB.getCif());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void deleteLegalPerson(int id) {

    }

    public LegalPersonDB getLegalPersonDB() {
        return legalPersonDB;
    }

    public void setLegalPersonDB(LegalPersonDB legalPersonDB) {
        this.legalPersonDB = legalPersonDB;
    }*/
}
