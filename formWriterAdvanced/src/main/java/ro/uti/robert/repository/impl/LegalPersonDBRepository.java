package ro.uti.robert.repository.impl;

import com.primarie.model.Person;
import org.hibernate.query.Query;
import ro.uti.robert.AdvancedWriter;
import ro.uti.robert.model.LegalPersonDB;
import ro.uti.robert.repository.LegalPersonRepository;

import javax.swing.*;

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
        Integer id = getLegalPersonId(legalPersonDB);
        if (id == null) {
            AdvancedWriter.getSession().save(legalPersonDB);
        } else {
            legalPersonDB.setId(id);
        }
        return legalPersonDB;
    }

    @Override
    public Integer getLegalPersonId(LegalPersonDB legalPersonDB) {
        Query query = AdvancedWriter.getSession().createQuery("select id from LegalPersonDB " +
                " where name = '" + legalPersonDB.getName() + "'"
                + " and cif = '" + legalPersonDB.getCif() + "'");


        Integer id = (Integer) query.uniqueResult();
        return id;
    }

    @Override
    public LegalPersonDB getLegalPerson(int id) {
        LegalPersonDB legalPersonDB = AdvancedWriter.getSession().get(LegalPersonDB.class, id);

        if (legalPersonDB != null) {
            return legalPersonDB;
        }
        JOptionPane.showMessageDialog(null, "No record with id = : " + id);
        return null;
    }

    @Override
    public Long countLegalPersons() {
        Query query = AdvancedWriter.getSession().createQuery("select count(id) from LegalPersonDB");

        Long id = (Long) query.uniqueResult();
        return id;
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
