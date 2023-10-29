package dao;

import models.Breed;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class BreedDao {
    public Breed findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Breed.class, id);
    }

    public void save(Breed breed) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(breed);
        tx.commit();
        session.close();
    }

    public void update(Breed breed) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(breed);
        tx.commit();
        session.close();
    }

    public void delete(Breed breed) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(breed);
        tx.commit();
        session.close();
    }

    public List<Breed> findAll() {
        List<Breed> breeds = (List<Breed>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().createQuery("FROM Breed").list();
        return breeds;
    }
}