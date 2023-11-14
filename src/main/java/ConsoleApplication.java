import dao.GenericDao;
import dao.ParticipationDao;
import models.*;
import org.hibernate.SessionFactory;
import utils.HibernateSessionFactoryUtil;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ConsoleApplication {

    private static final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int option = -1;

        do {
            option = chooseOption();
            proceed(option);
        } while (option != -1);

    }

    private static int chooseOption() {

        System.out.println("-------- Choose option --------");
        System.out.println();
        System.out.println("0. Show data");
        System.out.println();
        System.out.println("1. Add new animal");
        System.out.println("2. Add new breed");
        System.out.println("3. Add new client");
        System.out.println("4. Add new employee");
        System.out.println("5. Add new position");
        System.out.println("6. Add new exhibition");
        System.out.println();
        System.out.println("7. Create new request");
        System.out.println();
        System.out.println("8. Enter data on the participation of animals in exhibitions");
        System.out.println("9. Enter pedigree information");
        System.out.println();
        System.out.println("11. Update animal");
        System.out.println("12. Update breed");
        System.out.println("13. Update client");
        System.out.println("14. Update employee");
        System.out.println("15. Update position");
        System.out.println("16. Update exhibition");
        System.out.println("17. Update request");
        System.out.println();
        System.out.println("18. Update data on the participation of animals in exhibitions");
        // System.out.println("19. Update pedigree information");
        System.out.println();
        System.out.println("21. Delete animal");
        System.out.println("22. Delete breed");
        System.out.println("23. Delete client");
        System.out.println("24. Delete employee");
        System.out.println("25. Delete position");
        System.out.println("26. Delete exhibition");
        System.out.println("27. Delete request");
        System.out.println();
        System.out.println("28. Delete data on the participation of animals in exhibitions");
        // System.out.println("29. Delete pedigree information");
        System.out.println();
        System.out.println("-1. Exit");
        System.out.println("-------------------------------");
        System.out.print("\n> ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return choice;

    }

    private static void proceed(int option) {

        switch (option) {
            case 0:
                showData();
                break;
            case 1:
                addEntity(Animal.class);
                break;
            case 2:
                addEntity(Breed.class);
                break;
            case 3:
                addEntity(Client.class);
                break;
            case 4:
                addEntity(Employee.class);
                break;
            case 5:
                addEntity(Position.class);
                break;
            case 6:
                addEntity(Exhibition.class);
                break;
            case 7:
                addEntity(Request.class);
                break;
            case 8:
                addEntity(Participation.class);
                break;
            case 9:
                addPedigree();
                break;
            case 11:
                updateEntity(Animal.class);
                break;
            case 12:
                updateEntity(Breed.class);
                break;
            case 13:
                updateEntity(Client.class);
                break;
            case 14:
                updateEntity(Employee.class);
                break;
            case 15:
                updateEntity(Position.class);
                break;
            case 16:
                updateEntity(Exhibition.class);
                break;
            case 17:
                updateEntity(Request.class);
                break;
            case 18:
                updateEntity(Participation.class);
                break;
            case 21:
                deleteEntity(Animal.class);
                break;
            case 22:
                deleteEntity(Breed.class);
                break;
            case 23:
                deleteEntity(Client.class);
                break;
            case 24:
                deleteEntity(Employee.class);
                break;
            case 25:
                deleteEntity(Position.class);
                break;
            case 26:
                deleteEntity(Exhibition.class);
                break;
            case 27:
                deleteEntity(Request.class);
                break;
            case 28:
                deleteEntity(Participation.class);
                break;
            case -1:
                HibernateSessionFactoryUtil.shutdown();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice.");
        }

    }

    private static <T extends MyEntity> T selectEntity(Class<T> entityClass) {

        GenericDao<T> dao = new GenericDao<>(entityClass);
        List<T> entities = dao.findAll();

        int index = 1;
        for (T entity : entities) {
            System.out.println(index + ". " + entity);
            index++;
        }

        System.out.print("Select:\n> ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        try {
            return entities.get(choice - 1);

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Invalid choice.");
            return null;
        }

    }

    private static void enterAnimalDetails(Animal animal) {

        System.out.println("Enter Animal details.");

        System.out.print("Name: ");
        animal.setName(scanner.nextLine());

        System.out.print("Age: ");
        animal.setAge(scanner.nextInt());
        scanner.nextLine(); // consume newline

        System.out.print("Gender (MALE/FEMALE): ");
        String genderInput = scanner.nextLine();
        animal.setGender(Gender.fromString(genderInput.toLowerCase()));

        System.out.println("Breed:");
        animal.setBreed(selectEntity(Breed.class));

        System.out.print("Appearance: ");
        animal.setAppearance(scanner.nextLine());

        System.out.println("Client:");
        animal.setClient(selectEntity(Client.class));

        System.out.println("Vet:");
        animal.setVet(selectEntity(Employee.class)); // временно

        animal.setMother(null);
        animal.setFather(null);

    }

    private static void enterBreedDetails(Breed breed) {

        System.out.println("Enter Breed details.");

        System.out.print("Name: ");
        breed.setName(scanner.nextLine());

    }

    private static void enterClientDetails(Client client) {

        System.out.println("Enter Client details.");

        System.out.print("Last name: ");
        client.setLastName(scanner.nextLine());

        System.out.print("First name: ");
        client.setFirstName(scanner.nextLine());

        System.out.print("Patronymic: ");
        client.setPatronymic(scanner.nextLine());

        System.out.print("Address: ");
        client.setAddress(scanner.nextLine());

    }

    private static void enterEmployeeDetails(Employee employee) {

        System.out.println("Enter Employee details.");

        System.out.print("Last name: ");
        employee.setLastName(scanner.nextLine());

        System.out.print("First name: ");
        employee.setFirstName(scanner.nextLine());

        System.out.print("Patronymic: ");
        employee.setPatronymic(scanner.nextLine());

        System.out.print("Address: ");
        employee.setAddress(scanner.nextLine());

        System.out.println("Position:");
        employee.setPosition(selectEntity(Position.class));

        System.out.println("Salary:");
        employee.setSalary(new BigDecimal(scanner.nextInt()));

    }

    private static void enterExhibitionDetails(Exhibition exhibition) throws ParseException {

        System.out.println("Enter Exhibition details.");

        System.out.print("Name: ");
        exhibition.setName(scanner.nextLine());

        System.out.print("Address: ");
        exhibition.setAddress(scanner.nextLine());

        System.out.print("Date [dd.mm.yyyy]: ");
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date date = format.parse(scanner.nextLine());
        exhibition.setExhibitionDate(date);

    }

    private static void enterPositionDetails(Position position) {

        System.out.println("Enter Position details.");

        System.out.print("Name: ");
        position.setName(scanner.nextLine());

    }

    private static void enterParticipationDetails(Participation participation) {

        System.out.println("Enter Participation details.");

        ParticipationId id = new ParticipationId();

        System.out.println("Animal: ");
        id.setAnimal(selectEntity(Animal.class));

        System.out.println("Exhibition: ");
        id.setExhibition(selectEntity(Exhibition.class));

        participation.setId(id);

        System.out.print("Reward: ");
        participation.setReward(scanner.nextLine());

    }

    private static void enterRequestDetails(Request request) throws ParseException {

        System.out.println("Enter Request details.");

        System.out.println("Client:");
        request.setClient(selectEntity(Client.class));

        System.out.println("Breed:");
        request.setBreed(selectEntity(Breed.class));

        System.out.print("Gender (MALE/FEMALE): ");
        String genderInput = scanner.nextLine();
        request.setGender(Gender.fromString(genderInput.toLowerCase()));

        System.out.print("Date [dd.mm.yyyy]: ");
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date date = format.parse(scanner.nextLine());
        request.setRequestDate(date);

    }

    private static <T extends MyEntity> void enterDetails(T entity, Class<T> entityClass) throws ParseException {

        if (entityClass == Animal.class) enterAnimalDetails((Animal)entity);
        else if (entityClass == Breed.class) enterBreedDetails((Breed)entity);
        else if (entityClass == Client.class) enterClientDetails((Client)entity);
        else if (entityClass == Employee.class) enterEmployeeDetails((Employee)entity);
        else if (entityClass == Exhibition.class) enterExhibitionDetails((Exhibition) entity);
        else if (entityClass == Participation.class) enterParticipationDetails((Participation) entity);
        else if (entityClass == Position.class) enterPositionDetails((Position)entity);
        else if (entityClass == Request.class) enterRequestDetails((Request) entity);

    }

    private static <T extends MyEntity> void addEntity(Class<T> entityClass) {

        T newEntity = null;
        try {
            newEntity = entityClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException |
                 InvocationTargetException | NoSuchMethodException e) {
            System.out.println("Failed to add data: " + e.getMessage());
            return;
        }

        try {
            enterDetails(newEntity, entityClass);
        } catch (Exception e) {
            System.out.println("Failed to add data. There may have been an input error.\nError: " + e.getMessage());
            return;
        }

        if (entityClass != Participation.class) {
            GenericDao<T> dao = new GenericDao<>(entityClass);
            dao.save(newEntity);
        } else {
            ParticipationDao dao = new ParticipationDao();
            dao.save((Participation) newEntity);
        }


    }

    private static <T extends MyEntity> void updateEntity(Class<T> entityClass) {

        T selected = selectEntity(entityClass);
        if (selected == null) {
            System.out.println("Failed to update data.");
            return;
        }
        System.out.println("selected: " + selected);

        try {
            enterDetails(selected, entityClass);
        } catch (Exception e) {
            System.out.println("Failed to update data. There may have been an input error.");
        }

        if (entityClass != Participation.class) {
            GenericDao<T> dao = new GenericDao<>(entityClass);
            dao.update(selected);
        } else {
            ParticipationDao dao = new ParticipationDao();
            dao.update((Participation)selected);
        }

    }

    private static <T extends MyEntity> void deleteEntity(Class<T> entityClass) {

        T selected = selectEntity(entityClass);
        if (selected == null) {
            System.out.println("Failed to delete data.");
            return;
        }
        System.out.println("selected: " + selected);

        if (entityClass != Participation.class) {
            GenericDao<T> dao = new GenericDao<>(entityClass);
            dao.delete(selected);
        } else {
            ParticipationDao dao = new ParticipationDao();
            dao.delete((Participation)selected);
        }


    }

    private static void showData() {

        System.out.println("Select option:");
        System.out.println("1. Show ANIMALS");
        System.out.println("2. Show BREEDS");
        System.out.println("3. Show CLIENTS");
        System.out.println("4. Show EMPLOYEES");
        System.out.println("5. Show POSITIONS");
        System.out.println("6. Show EXHIBITIONS");
        System.out.println("7. Show REQUESTS");
        System.out.println("8. Show PARTICIPATIONS of selected animal");
        System.out.println("9. Show PEDIGREE of selected animal");
        System.out.println("10. Show animals for selected request");
        System.out.print("> ");

        int option;
        try {
            option = scanner.nextInt();
            if (option < 1 || option > 10) {
                System.out.println("Wrong input.");
                return;
            }
        } catch (Exception e) {
            System.out.println("Wrong input.");
            return;
        }

        switch (option) {
            case 1 -> showList(Animal.class);
            case 2 -> showList(Breed.class);
            case 3 -> showList(Client.class);
            case 4 -> showList(Employee.class);
            case 5 -> showList(Position.class);
            case 6 -> showList(Exhibition.class);
            case 7 -> showList(Request.class);
            case 8 -> showList(Participation.class);
            case 9 -> printFamilyTree(selectEntity(Animal.class), "");
        }

    }

    private static <T extends MyEntity> void showList(Class<T> entityClass) {

        List<T> list;
        if (entityClass != Participation.class) {
            GenericDao<T> dao = new GenericDao<>(entityClass);
            list = dao.findAll();
        } else {
            ParticipationDao dao = new ParticipationDao();
            list = (List<T>)dao.findAll();
        }

        for (T entity : list) {
            System.out.println(entity);
        }
    }

    public static void printFamilyTree(Animal animal, String prefix) {
        if (animal == null) {
            return;
        }

        System.out.println(prefix + "+-- " + animal.getName());

        String newPrefix = prefix.isEmpty() ? "    " : prefix + "|   ";

        if (animal.getMother() != null) {
            printFamilyTree(animal.getMother(), newPrefix);
        }

        if (animal.getFather() != null) {
            printFamilyTree(animal.getFather(), newPrefix);
        }
    }

    public static void addPedigree() {

        System.out.println("Animal:");
        Animal animal = selectEntity(Animal.class);
        assert animal != null;

        System.out.println("Pedigree:");
        printFamilyTree(animal, "");

        GenericDao<Animal> dao = new GenericDao<>(Animal.class);

        List<Animal> females = dao.findAll();
        females.removeIf(anim -> anim.getGender() == Gender.MALE || anim.getId() == animal.getId());

        List<Animal> males = dao.findAll();
        males.removeIf(anim -> anim.getGender() == Gender.FEMALE || anim.getId() == animal.getId());

        System.out.println("Mother:");
        int index = 1;
        for (Animal anim : females) {
            System.out.println(index + ". " + anim);
            index++;
        }

        System.out.print("Select:\n> ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        try {
            animal.setMother(females.get(choice - 1));
            dao.save(animal);

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Invalid choice.");
        }

        System.out.println("Father:");
        index = 1;
        for (Animal anim : males) {
            System.out.println(index + ". " + anim);
            index++;
        }

        System.out.print("Select:\n> ");
        choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        try {
            animal.setFather(males.get(choice - 1));
            dao.save(animal);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Invalid choice.");
        }

        System.out.println("Pedigree:");
        printFamilyTree(animal, "");

    }
}
