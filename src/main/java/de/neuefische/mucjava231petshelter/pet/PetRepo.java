package de.neuefische.mucjava231petshelter.pet;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepo extends MongoRepository<Pet,String> {

    List<Pet> findAllBySpecies(String species);
    List<Pet> findAllByAge(Integer age);

    List<Pet> findAllByNameStartingWith(String prefix);
    List<Pet>  findByNameStartingWithIgnoreCase(String name);

    List<Pet> findAllByOwnerId(String ownerId);
}
