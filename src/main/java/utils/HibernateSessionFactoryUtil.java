package utils;

import models.*;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.TypeDef;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

@TypeDef(name = "gen", typeClass = GenderType.class)
public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Database connection settings
                configuration.setProperty(Environment.DRIVER, "org.postgresql.Driver");
                configuration.setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/rpbd_lab1");
                configuration.setProperty(Environment.USER, "rpbd_user");
                configuration.setProperty(Environment.PASS, "1234");

                // Specify dialect
                configuration.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");

                // Custom type registration
                configuration.addAnnotatedClass(Breed.class)
                        .addAnnotatedClass(Client.class)
                        .addAnnotatedClass(Position.class)
                        .addAnnotatedClass(Exhibition.class)
                        .addAnnotatedClass(Employee.class)
                        .addAnnotatedClass(Animal.class)
                        .addAnnotatedClass(Participation.class)
                        .addAnnotatedClass(Request.class)
                        .addAnnotatedClass(GenderType.class);

                // Build the ServiceRegistry
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build();

                // Build the SessionFactory
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                System.out.println("Exception!" + e);
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}