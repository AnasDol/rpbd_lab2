package dao;

import models.Animal;
import models.Exhibition;
import models.Participation;
import models.ParticipationId;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class ParticipationDao {
    private final SessionFactory sessionFactory;

    public ParticipationDao() {
        sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
    }

    public Participation findById(Animal animal, Exhibition exhibition) {
        Session session = sessionFactory.openSession();
        Participation entity = session.get(Participation.class, new ParticipationId(animal, exhibition));
        session.close();
        return entity;
    }

    public void save(Participation entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            session.close();
            System.out.println("Added data successfully.");
        } catch (Exception e) {
            System.out.println("Failed to add data: " + e.getMessage());
        }
    }

    public void update(Participation entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
            session.close();
            System.out.println("Updated data successfully.");
        } catch (Exception e) {
            System.out.println("Failed to update data: " + e.getMessage());
        }
    }

    public void delete(Participation entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
            session.close();
            System.out.println("Deleted data successfully.");
        } catch (Exception e) {
            System.out.println("Failed to delete data: " + e.getMessage());
        }
    }

    public List<Participation> findAll() {
        Session session = sessionFactory.openSession();
        List<Participation> entities = session.createQuery("FROM " + Participation.class.getSimpleName(), Participation.class).list();
        session.close();
        return entities;
    }

}