package ru.sapteh.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.Dao;
import ru.sapteh.models.ClientService;

import java.util.List;

public class ClientServiceDaoImpl implements Dao<ClientService, Integer> {
    private final SessionFactory factory;

    public ClientServiceDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public ClientService findById(Integer integer) {
        return null;
    }

    @Override
    public List<ClientService> readByAll() {
       try (Session session = factory.openSession()){
           Query<ClientService> query = session.createQuery("FROM ClientService");
           return query.list();
       }
    }

    @Override
    public void create(ClientService clientService) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(clientService);
            session.getTransaction();
        }
    }

    @Override
    public void update(ClientService clientService) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(clientService);
            session.getTransaction();
        }
    }

    @Override
    public void delete(ClientService clientService) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(clientService);
            session.getTransaction();
        }
    }
}
