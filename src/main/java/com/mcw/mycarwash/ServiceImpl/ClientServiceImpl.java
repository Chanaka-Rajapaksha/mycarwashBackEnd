package com.mcw.mycarwash.ServiceImpl;

import com.mcw.mycarwash.Dao.ClientDao;
import com.mcw.mycarwash.Model.Client;
import com.mcw.mycarwash.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    @Transactional
    @Override
    public List<Client> getClientList() {
        return clientDao.getClientList();
    }

    @Transactional
    @Override
    public Client get(String id) {
        return clientDao.get(id);
    }
    @Transactional
    @Override
    public void saveClient(Client client) {
        clientDao.saveClient(client);

    }
    @Transactional
    @Override
    public void deleteClient(String id) {
    clientDao.deleteClient(id);
    }
}
