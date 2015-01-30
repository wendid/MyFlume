package org.hanzhi.ps.tailor.user.dao;

/**
 * Created by hanzhi on 15-1-30.
 */

import org.hanzhi.ps.tailor.user.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public List<User> getAllUser() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User");

        return query.list();
    }
}
