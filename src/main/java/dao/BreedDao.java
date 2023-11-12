package dao;

import models.Breed;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class BreedDao {

    private final SessionFactory sessionFactory;

    public BreedDao() {
        sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
    }
    public Breed findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Breed.class, id);
    }

    public void save(Breed breed) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(breed);
            session.getTransaction().commit();
            session.close();
            System.out.println("Added data successfully.");
        } catch (Exception e) {
            System.out.println("Failed to add data: " + e.getMessage());
        }
    }

    public void update(Breed breed) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(breed);
            session.getTransaction().commit();
            session.close();
            System.out.println("Updated data successfully.");
        } catch (Exception e) {
            System.out.println("Failed to update data: " + e.getMessage());
        }
    }

    public void delete(Breed breed) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(breed);
            session.getTransaction().commit();
            session.close();
            System.out.println("Deleted data successfully.");
        } catch (Exception e) {
            System.out.println("Failed to delete data: " + e.getMessage());
        }
    }

    public List<Breed> findAll() {
        List<Breed> breeds = (List<Breed>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().createQuery("FROM Breed").list();
        return breeds;
    }
}