package ro.uti.robert.repository.impl;

import org.hibernate.query.Query;
import ro.uti.robert.AdvancedWriter;
import ro.uti.robert.model.AddressDB;
import ro.uti.robert.repository.AddressRepository;

public class AddressDBRepository implements AddressRepository {

    public AddressDBRepository() {

    }

    @Override
    public AddressDB saveAddress(AddressDB addressDB) {

        Query query = AdvancedWriter.getSession().createQuery("select id from AddressDB " +
                " where number = " + addressDB.getNumber()
                + " and street = '" + addressDB.getStreet() + "'"
                + " and city = '" + addressDB.getCity() + "'"
                + " and county = '" + addressDB.getCounty() + "'"
                + " and country = '" + addressDB.getCountry() + "'"
                + " and postalCode = '" + addressDB.getPostalCode() + "'");

        Integer id = (Integer) query.uniqueResult();


        if (id == null) {
            AdvancedWriter.getSession().save(addressDB);
        } else {
            addressDB.setId(id);
        }
        return addressDB;


    }

    /*@Override
    public boolean checkForExistence(AddressDB addressDB) {
        try {
            PreparedStatement preparedStatement = AdvancedWriter.getConnection().prepareStatement(
                    "SELECT * FROM validated_forms.address where number = " + addressDB.getNumber()
                            + " and street = '" + addressDB.getStreet() + "' "
                            + " and city = '" + addressDB.getCity() + "'"
                            + " and county = '" + addressDB.getCounty() + "'"
                            + " and country = '" + addressDB.getCountry() + "'"
                            + " and postalcode = '" + addressDB.getPostalCode() + "'");

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
    public void deleteAddress(int id) {

    }

    public AddressDB getAddressDB() {
        return addressDB;
    }

    public void setAddressDB(AddressDB addressDB) {
        this.addressDB = addressDB;
    }*/
}
