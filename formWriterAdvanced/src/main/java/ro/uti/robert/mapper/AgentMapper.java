package ro.uti.robert.mapper;

import ro.uti.robert.model.AgentDB;
import ro.uti.robert.model.PersonDB;


public class AgentMapper {
    private static AgentDB agentDB;
    private static PersonDB personDB;


    public AgentMapper() {
        agentDB = new AgentDB();
        personDB = new PersonDB();
    }

    public AgentDB toAgentDB(PersonDB personDB) {
        agentDB.setIndividualPersonId(personDB.getIndividualPersonId());
        return agentDB;
    }
}
