package ro.uti.robert.mapper;

import com.primarie.model.IndividualPerson;
import ro.uti.robert.model.AddressDB;
import ro.uti.robert.model.IndividualPersonDB;

public class IndividualPersonMapper {
    private IndividualPersonDB individualPersonDB;
    private IndividualPerson individualPerson;
    private AddressDB addressDB;

    public IndividualPersonMapper(){
        individualPersonDB = new IndividualPersonDB();
        individualPerson = new IndividualPerson();

    }

    public IndividualPersonDB toIndividualPersonDB(IndividualPerson individualPerson){
        individualPersonDB.setCnp(individualPerson.getCnp());
        individualPersonDB.setLastName(individualPerson.getLastName());
        individualPersonDB.setFirstName(individualPerson.getFirstName());
        individualPersonDB.setCitizenship(individualPerson.getCitizenship());
        return individualPersonDB;

    }

    public IndividualPerson toIndividualPerson(IndividualPersonDB individualPersonDB){
        individualPerson.setCnp(individualPersonDB.getCnp());
        individualPerson.setLastName(individualPersonDB.getLastName());
        individualPerson.setFirstName(individualPersonDB.getFirstName());
        individualPerson.setCitizenship(individualPersonDB.getCitizenship());
        return individualPerson;
    }

}
