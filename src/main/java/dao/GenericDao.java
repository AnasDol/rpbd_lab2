package dao;

import models.MyEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class GenericDao<T extends MyEntity> {

    private final Class<T> entityClass;
    private final SessionFactory sessionFactory;

    public GenericDao(Class<T> entityClass) {
        this.entityClass = entityClass;
        sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
    }

    public T findById(int id) {
        Session session = sessionFactory.openSession();
        T entity = session.get(entityClass, id);
        session.close();
        return entity;
    }

    public void save(T entity) {
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

    public void update(T entity) {
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

    public void delete(T entity) {
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

    public List<T> findAll() {
       Session session = sessionFactory.openSession();
       List<T> entities = session.createQuery("FROM " + entityClass.getSimpleName(), entityClass).list();
       session.close();
       return entities;
    }
}