package com.mcw.mycarwash.DaoImpl;

import com.mcw.mycarwash.Dao.ClientDao;
import com.mcw.mycarwash.Model.Client;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ClientDaoImpl implements ClientDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Client> getClientList() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Client> query = currentSession.createQuery("FROM Client", Client.class);
        List<Client> clientList = query.getResultList();
        return clientList;
    }

    @Override
    public Client get(String id) {
       Session currentSession = entityManager.unwrap(Session.class);
       Client client = currentSession.get(Client.class,id);
       return  client;
    }

    @Override
    public void saveClient(Client client) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(client);
    }

    @Override
    public void deleteClient(String id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Client client = currentSession.get(Client.class,id);
        currentSession.delete(id);
    }
}
