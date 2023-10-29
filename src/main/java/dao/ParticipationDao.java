package dao;

import models.Participation;
import models.ParticipationId;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class ParticipationDao {
    public Participation findById(int animalId, int exhibitionId) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Participation.class,
                new ParticipationId(animalId, exhibitionId));
    }

    public void save(Participation participation) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(participation);
        tx1.commit();
        session.close();
    }

    public void update(Participation participation) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(participation);
        tx1.commit();
        session.close();
    }

    public void delete(Participation participation) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(participation);
        tx1.commit();
        session.close();
    }

    public List<Participation> findAll() {
        List<Participation> participations = (List<Participation>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Participation").list();
        return participations;
    }

    public Participation findAutoById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Participation.class,
                id);
    }
}