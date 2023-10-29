package dao;

import models.Animal;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class AnimalDao {
    public Animal findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Animal.class, id);
    }

    public void save(Animal animal) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(animal);
        tx.commit();
        session.close();
    }

    public void update(Animal animal) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(animal);
        tx.commit();
        session.close();
    }

    public void delete(Animal animal) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(animal);
        tx.commit();
        session.close();
    }

    public List<Animal> findAll() {
        List<Animal> animals = (List<Animal>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().createQuery("FROM Animal").list();
        return animals;
    }
}