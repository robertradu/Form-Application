package ro.uti.robert.repository;

import ro.uti.robert.model.AgentDB;

public interface AgentRepository {
    AgentDB saveAgent(AgentDB agentDB);

    boolean checkForExistence(AgentDB agentDB);

    void deleteAgent(int id);
}
