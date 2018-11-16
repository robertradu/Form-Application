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

    /**
     * Searches the id of the specified record of type {@link AgentDB} exists
     *
     * @param agentDB
     * @return
     */
    Integer getAgentId(AgentDB agentDB);

    /**
     * Searches the specified record of type {@link AgentDB}
     * @param id
     * @return
     */
    AgentDB getAgent(int id);

    /**
     * Counts all entities {@link AgentDB} existent in DB
     * @return
     */
    Long countAgents();
   // boolean checkForExistence(AgentDB agentDB);

  //  void deleteAgent(int id);
}
