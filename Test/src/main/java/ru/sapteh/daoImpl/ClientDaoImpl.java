package ru.sapteh.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.Dao;
import ru.sapteh.models.Client;

import java.util.List;

public class ClientDaoImpl implements Dao<Client, Integer> {
    private final SessionFactory factory;

    public ClientDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Client findById(Integer integer) {
        return null;
    }

    @Override
    public List<Client> readByAll() {
        try(Session session = factory.openSession()){
            Query<Client> query = session.createQuery("FROM Client");
            return query.list();
        }
    }

    @Override
    public void create(Client client) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(client);
            session.getTransaction();
        }
    }

    @Override
    public void update(Client client) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(client);
            session.getTransaction();
        }
    }

    @Override
    public void delete(Client client) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(client);
            session.getTransaction();
        }
    }
}
