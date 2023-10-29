import models.Breed;
import services.BreedService;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        BreedService breedService = new BreedService();
        Breed breed = new Breed("sphinx");
        breedService.saveBreed(breed);

    }
}
