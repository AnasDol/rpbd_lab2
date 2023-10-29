package dao;

import models.Exhibition;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class ExhibitionDao {

    public Exhibition findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Exhibition.class, id);
    }

    public void save(Exhibition exhibition) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(exhibition);
        tx.commit();
        session.close();
    }

    public void update(Exhibition exhibition) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(exhibition);
        tx.commit();
        session.close();
    }

    public void delete(Exhibition exhibition) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(exhibition);
        tx.commit();
        session.close();
    }

    public List<Exhibition> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Exhibition> exhibitions = session.createQuery("FROM Exhibition", Exhibition.class).list();
        session.close();
        return exhibitions;
    }
}