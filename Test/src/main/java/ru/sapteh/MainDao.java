package ru.sapteh;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.Dao;
import ru.sapteh.daoImpl.ClientDaoImpl;
import ru.sapteh.models.Client;
import ru.sapteh.models.ClientService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public class MainDao {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Dao<Client, Integer> clientDao = new ClientDaoImpl(factory);
        List<Client> clients = clientDao.readByAll();

        for (Client client : clients){
            Set<ClientService> clientServices = client.getClientServices();
            if (clientServices.size() != 0 ){
                for (ClientService clientService: clientServices){
                    Date startTime = clientService.getStartTime();
                    System.out.println(startTime);
                }
            }
        }
    }
}
