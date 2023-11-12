import models.Animal;
import models.Breed;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateSessionFactoryUtil;

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
                //addAnimal();
                break;
            case 2:
                addBreed();
                break;
            case 3:
                //addClient();
                break;
            case 4:
                //addEmployee();
                break;
            case 5:
                //addPosition();
                break;
            case 6:
                //addExhibition();
                break;
            case 7:
                //createNewRequest();
                break;
            case 8:
                //enterAnimalParticipationData();
                break;
            case 9:
                //enterPedigreeInformation();
                break;
            case 11:
                //updateAnimal();
                break;
            case 12:
                updateBreed();
                break;
            case 13:
                //updateClient();
                break;
            case 14:
                //updateEmployee();
                break;
            case 15:
                //updatePosition();
                break;
            case 16:
                //updateExhibition();
                break;
            case 17:
                //updateRequest();
                break;
            case 18:
                //updateAnimalParticipationData();
                break;
            case 21:
                //deleteAnimal();
                break;
            case 22:
                //deleteBreed();
                break;
            case 23:
                //deleteClient();
                break;
            case 24:
                //deleteEmployee();
                break;
            case 25:
                //deletePosition();
                break;
            case 26:
                //deleteExhibition();
                break;
            case 27:
                //deleteRequest();
                break;
            case 28:
                //deleteAnimalParticipationData();
                break;
            case -1:
                HibernateSessionFactoryUtil.shutdown();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice.");
        }

    }

    private static void addBreed() {

        Breed newEntity = new Breed();

        try {
            enterBreedDetails(newEntity);
        } catch (Exception e) {
            System.out.println("Failed to update data. There may have been an input error.");
        }

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(newEntity);
            session.getTransaction().commit();
            System.out.println("Added data successfully.");
        } catch (Exception e) {
            System.out.println("Failed to add data: " + e.getMessage());
        }
    }

    private static Breed selectBreed() {
        try (Session session = sessionFactory.openSession()) {



            List<Breed> breeds = session.createQuery("FROM Breed", Breed.class).list();

            System.out.println("Breed list:");
            int index = 1;
            for (Breed breed : breeds) {
                System.out.println(index + ". " + breed);
                index++;
            }

            System.out.print("Select breed to update:\n> ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                return breeds.get(choice - 1);

            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Invalid choice.");
                return null;
            }

        } catch (Exception e) {
            System.out.println("Error retrieving Breed list: " + e.getMessage());
            return null;
        }

    }

    private static void updateBreed() {

        Breed selected = selectBreed();
        if (selected == null) {
            System.out.println("Failed to update data.");
            return;
        }
        System.out.println("selected: " + selected);

        try {
            enterBreedDetails(selected);
        } catch (Exception e) {
            System.out.println("Failed to update data. There may have been an input error.");
        }


    }
 try (Session session = sessionFactory.openSession()) {
        session.beginTransaction();
        session.update(selected);
        session.getTransaction().commit();
        System.out.println("Updated data successfully.");
    } catch (Exception e) {
        System.out.println("Failed to update data: " + e.getMessage());
    }
    private static void enterBreedDetails(Breed breed) {

        System.out.println("Enter Breed details:");

        System.out.print("Name: ");
        breed.setName(scanner.nextLine());

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

    }


    private static void showAnimalList() {
        try (Session session = sessionFactory.openSession()) {
            List<Animal> animals = session.createQuery("FROM Animal", Animal.class).list();

            System.out.println("Animal List:");
            for (Animal animal : animals) {
                System.out.println(animal);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving Animal list: " + e.getMessage());
        }
    }
}
