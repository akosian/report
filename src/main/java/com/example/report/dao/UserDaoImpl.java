package com.example.report.dao;

import com.example.report.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public synchronized void addUser(User user) {
        Session session = getSession();
        session.save(user);
        finishTransaction(session);
    }

    @Override
    public synchronized void updateUser(User user) {
        Session session = getSession();
        session.update(user);
        finishTransaction(session);
    }

    @Override
    public synchronized void removeUser(int id) {
        Session session = getSession();
        User user = session.load(User.class, id);
        if (user != null) {
            session.delete(user);
        }
        finishTransaction(session);
    }

    @Override
    public synchronized List<User> userList() {
        Session session = getSession();
        List<User> users = session.createQuery("from User").list();
        finishTransaction(session);
        return users;
    }

    @Override
    public synchronized User getUserById(int id) {
        Session session = getSession();
        User user = session.load(User.class, id);

        finishTransaction(session);
        if (user != null) {
            return user;
        } else {
            return null;
        }
    }

    private void finishTransaction(Session session) {
        session.getTransaction().commit();
        session.close();
    }

    private Session getSession() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session;
    }
}