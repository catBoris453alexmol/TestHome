package ru.sapteh.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.Dao;
import ru.sapteh.models.Gender;

import java.util.List;

public class GenderDaoImpl implements Dao<Gender, Integer> {
    private final SessionFactory factory;

    public GenderDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Gender findById(Integer integer) {
        return null;
    }

    @Override
    public List<Gender> readByAll() {
        try (Session session = factory.openSession()){
            Query<Gender> query = session.createQuery("FROM Gender");
            return query.list();
        }
    }

    @Override
    public void create(Gender gender) {

    }

    @Override
    public void update(Gender gender) {

    }

    @Override
    public void delete(Gender gender) {

    }
}
