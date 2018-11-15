package ro.uti.robert.repository;

import ro.uti.robert.model.AgentDB;

public interface AgentRepository {
    /**
     * Creates or updates an entity of type {@link AgentDB}.
     *
     * @param agentDB
     * @return: return the ID for created entity
     */
    AgentDB saveAgent(AgentDB agentDB);

   // boolean checkForExistence(AgentDB agentDB);

  //  void deleteAgent(int id);
}
