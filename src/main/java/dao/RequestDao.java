package dao;

import models.Request;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class RequestDao {
    public Request findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Request.class, id);
    }

    public void save(Request request) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(request);
        tx.commit();
        session.close();
    }

    public void update(Request request) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(request);
        tx.commit();
        session.close();
    }

    public void delete(Request request) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(request);
        tx.commit();
        session.close();
    }

    public List<Request> findAll() {
        List<Request> requests = (List<Request>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession()
                .createQuery("FROM Request")
                .list();
        return requests;
    }
}