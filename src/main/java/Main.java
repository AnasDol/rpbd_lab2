import dao.*;
import models.*;
import org.hibernate.Session;
import utils.HibernateSessionFactoryUtil;

import java.math.BigDecimal;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            GenericDao<Employee> empDao = new GenericDao<>(Employee.class);
            GenericDao<Position> posDao = new GenericDao<>(Position.class);
            Position position = new Position("top");
            posDao.save(position);
            BigDecimal salary = new BigDecimal(1000);
            Employee employee = new Employee("Test", "Toster", "Tristan",
                    "Tatarstan", position, salary);
            empDao.save(employee);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }




        HibernateSessionFactoryUtil.shutdown();

    }
}
