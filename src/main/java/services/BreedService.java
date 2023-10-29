package services;

import dao.BreedDao;
import models.Breed;

import java.util.List;

public class BreedService {
    private BreedDao breedDao = new BreedDao();

    public BreedService() {
    }

    public Breed findBreed(int id) {
        return breedDao.findById(id);
    }

    public void saveBreed(Breed breed) {
        breedDao.save(breed);
    }

    public void deleteBreed(Breed breed) {
        breedDao.delete(breed);
    }

    public void updateBreed(Breed breed) {
        breedDao.update(breed);
    }

    public List<Breed> findAllBreeds() {
        return breedDao.findAll();
    }
}
