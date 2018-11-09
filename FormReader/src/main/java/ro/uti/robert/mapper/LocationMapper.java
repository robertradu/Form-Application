package ro.uti.robert.mapper;

import com.primarie.model.Location;
import ro.uti.robert.model.AddressDB;
import ro.uti.robert.model.CoordinatesDB;
import ro.uti.robert.model.LocationDB;

public class LocationMapper {
    private LocationDB locationDB;
    private Location location;
    private AddressDB addressDB;
    private CoordinatesDB coordinatesDB;

    public LocationMapper(AddressDB addressDB, CoordinatesDB coordinatesDB) {
        locationDB = new LocationDB();
        location = new Location();
        this.addressDB = addressDB;
        this.coordinatesDB = coordinatesDB;

    }

    public LocationDB toLocationDB(Location location) {
        locationDB.setAddressId(addressDB.getId());
        locationDB.setCoordinatesId(coordinatesDB.getId());
        locationDB.setDescription(location.getDescription());
        return locationDB;
    }

    public Location toLocation(LocationDB locationDB) {
        AddressMapper addressMapper = new AddressMapper();
        CoordinatesMapper coordinatesMapper = new CoordinatesMapper();
        location.setAddress(addressMapper.toAddress(addressDB));
        location.setCoordinates(coordinatesMapper.toCoordinates(coordinatesDB));
        location.setDescription(location.getDescription());
        return location;
    }
}
