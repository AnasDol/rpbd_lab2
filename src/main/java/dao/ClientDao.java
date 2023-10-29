package dao;

import models.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class ClientDao {
    public Client findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Client.class, id);
    }

    public void save(Client client) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(client);
        tx.commit();
        session.close();
    }

    public void update(Client client) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(client);
        tx.commit();
        session.close();
    }

    public void delete(Client client) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(client);
        tx.commit();
        session.close();
    }

    public List<Client> findAll() {
        return (List<Client>) HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createQuery("FROM Client").list();
    }
}