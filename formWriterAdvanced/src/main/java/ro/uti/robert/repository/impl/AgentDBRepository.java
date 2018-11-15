package ro.uti.robert.repository.impl;

import org.hibernate.query.Query;
import ro.uti.robert.AdvancedWriter;
import ro.uti.robert.model.AgentDB;
import ro.uti.robert.repository.AgentRepository;

public class AgentDBRepository implements AgentRepository {

    public AgentDBRepository() {

    }

    @Override
    public AgentDB saveAgent(AgentDB agentDB) {
        Query query = AdvancedWriter.getSession().createQuery("select id from AgentDB " +
                " where individualPersonId = " + agentDB.getIndividualPersonId());


        Integer id = (Integer) query.uniqueResult();

        if (id == null) {
            AdvancedWriter.getSession().save(agentDB);
        } else {
            agentDB.setId(id);
        }

        return agentDB;
    }

   /* @Override
    public boolean checkForExistence(AgentDB agentDB) {
        try {
            PreparedStatement preparedStatement = AdvancedWriter.getConnection().prepareStatement(
                    "SELECT * FROM validated_forms.agent where individualperson_id = " + agentDB.getIndividualPersonId());

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
    public void deleteAgent(int id) {

    }*/
}
