import dao.ClientDao;
import models.Breed;
import models.Client;
import services.BreedService;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
//        BreedService breedService = new BreedService();
//        Breed breed = new Breed("sphinx");
//        breedService.saveBreed(breed);

        ClientDao clientDao = new ClientDao();
        Client client = new Client("Doe", "John", "", "29 BQ Street");
        clientDao.save(client);

    }
}
