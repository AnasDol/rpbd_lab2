package utils;

import models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;
    private HibernateSessionFactoryUtil() {}
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Breed.class);
                configuration.addAnnotatedClass(Client.class);
                configuration.addAnnotatedClass(Position.class);
                configuration.addAnnotatedClass(Exhibition.class);
                configuration.addAnnotatedClass(Employee.class);
                configuration.addAnnotatedClass(Animal.class);
                configuration.addAnnotatedClass(Participation.class);
                configuration.addAnnotatedClass(Request.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}
