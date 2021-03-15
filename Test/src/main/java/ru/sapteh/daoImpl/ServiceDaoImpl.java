package ru.sapteh.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.Dao;
import ru.sapteh.models.Service;

import java.util.List;

public class ServiceDaoImpl implements Dao<Service, Integer> {
    private final SessionFactory factory;

    public ServiceDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Service findById(Integer integer) {
        return null;
    }

    @Override
    public List<Service> readByAll() {
        try (Session session = factory.openSession()){
            Query<Service> query = session.createQuery("FROM Service");
            return query.list();
        }
    }

    @Override
    public void create(Service service) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(service);
            session.getTransaction();
        }
    }

    @Override
    public void update(Service service) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(service);
            session.getTransaction();
        }
    }

    @Override
    public void delete(Service service) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(service);
            session.getTransaction();
        }
    }
}
