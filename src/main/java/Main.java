import dao.*;
import models.*;
import services.BreedService;

import java.math.BigDecimal;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        BreedDao breedDao = new BreedDao();
        Breed breed = breedDao.findById(12);

        ClientDao clientDao = new ClientDao();
//        Client client = new Client("Willis", "Bruce", "", "");
//        clientDao.save(client);
        Client client = clientDao.findById(11);

        Position position = new PositionDao().findById(1);

        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = new Employee("Jog", "The Big", "", "", position, new BigDecimal(1000));
        employeeDao.save(employee);

        Animal animal = new Animal("Lisa", 5, Gender.FEMALE, breed, "", client, employee, null, null);
        AnimalDao animalDao = new AnimalDao();
        animalDao.save(animal);
    }
}
