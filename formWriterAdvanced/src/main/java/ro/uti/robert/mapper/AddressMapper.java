package ro.uti.robert.mapper;

import com.primarie.model.Address;
import ro.uti.robert.model.AddressDB;

/**
 * Service used to map entities of type {@link Address}
 * and {@link ro.uti.robert.model.AddressDB}
 */
public class AddressMapper {
    private AddressDB addressDB;
    private Address address;

    public AddressMapper() {
        address = new Address();
        addressDB = new AddressDB();
    }

    public AddressDB toAddressDB(Address address) {
        addressDB.setNumber(address.getNumber());
        addressDB.setStreet(address.getStreet());
        addressDB.setCity(address.getCity());
        addressDB.setCounty(address.getCounty());
        addressDB.setCountry(address.getCountry());
        addressDB.setPostalCode(address.getPostalCode());
        return addressDB;
    }

    public Address toAddress(AddressDB addressDB) {

        address.setNumber(addressDB.getNumber());
        address.setStreet(addressDB.getStreet());
        address.setCity(addressDB.getCity());
        address.setCounty(addressDB.getCounty());
        address.setCountry(addressDB.getCountry());
        address.setPostalCode(addressDB.getPostalCode());
        return address;
    }

    public AddressDB getAddressDB() {
        return addressDB;
    }

    public void setAddressDB(AddressDB addressDB) {
        this.addressDB = addressDB;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
