package dao;

import models.Position;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;

public class PositionDao {
    public Position findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Position.class, id);
    }

    public void save(Position position) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(position);
        tx.commit();
        session.close();
    }

    public void update(Position position) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(position);
        tx.commit();
        session.close();
    }

    public void delete(Position position) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(position);
        tx.commit();
        session.close();
    }

    public List<Position> findAll() {
        List<Position> positions = (List<Position>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().createQuery("FROM Position").list();
        return positions;
    }
}