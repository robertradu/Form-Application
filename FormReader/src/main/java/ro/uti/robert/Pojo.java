package ro.uti.robert;

import com.primarie.model.IndividualPerson;
import com.primarie.model.Location;
import com.primarie.model.Person;

import java.time.LocalDateTime;

public class Pojo {
    private Person applicant;
    private String details;
    private String authorizationNr;
    private Location location;
    private Person person;
    private Person agent;
    private String data;
    private LocalDateTime recordDate;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
        setRecordDate(LocalDateTime.parse(data));
    }


    public LocalDateTime getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDateTime recordDate) {
        this.recordDate = recordDate;
    }

    public Person getApplicant() {
        return applicant;
    }

    public void setApplicant(Person applicant) {
        this.applicant = applicant;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getAuthorizationNr() {
        return authorizationNr;
    }

    public void setAuthorizationNr(String authorizationNr) {
        this.authorizationNr = authorizationNr;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getAgent() {
        return agent;
    }

    public void setAgent(Person agent) {
        this.agent = agent;
    }

    /*public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("     Applicant:  " + getApplicant());
        sb.append(" Nume : " + getApplicant().getNume());
        sb.append(" Prenume : " + getApplicant().getPrenume());
        sb.append(" CNP : " + getApplicant().getCnp());
        sb.append(" Cetatenie : " + getApplicant().getCetatenie());
        sb.append(" Telefon : " + getApplicant().getTelefon());
        sb.append(" Adresa : " + getApplicant().getAdresa());
        sb.append(" Numar : " + getApplicant().getAdresa().getNumar());
        sb.append(" Strada : " + getApplicant().getAdresa().getStrada());
        sb.append(" Localitate : " + getApplicant().getAdresa().getLocalitate());
        sb.append(" Judet : " + getApplicant().getAdresa().getJudet());
        sb.append(" Tara : " + getApplicant().getAdresa().getTara());
        sb.append(" CodPostal : " + getApplicant().getAdresa().getCodPostal());
        sb.append(" Details: " + getDetails());
        sb.append(" Authorization Number: " + getAuthorizationNr());
        sb.append(" Location: " + getLocation());
        sb.append(" Person: " + getPerson());
        sb.append(" Agent: " + getAgent());
        return sb.toString();
    }*/
}
