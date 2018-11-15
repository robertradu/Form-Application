package ro.uti.robert.model;

import com.primarie.model.Form;
import com.primarie.model.HospitalForm;
import com.primarie.model.Person;

public class IndividualPersonDB {

    private Integer id;
    private String cnp;
    private String lastName;
    private String firstName;
    private String citizenship;


    public IndividualPersonDB() {
    }

    public IndividualPersonDB(Person person) {
        this.cnp = person.getIndividualPerson().getCnp();
        this.lastName = person.getIndividualPerson().getLastName();
        this.firstName = person.getIndividualPerson().getFirstName();
        this.citizenship = person.getIndividualPerson().getCitizenship();
        this.id++;
    }

    ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }
}
