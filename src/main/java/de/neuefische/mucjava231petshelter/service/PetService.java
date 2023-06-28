package de.neuefische.mucjava231petshelter.service;

import de.neuefische.mucjava231petshelter.exception.PetNotFoundExceptoin;
import de.neuefische.mucjava231petshelter.model.Owner;
import de.neuefische.mucjava231petshelter.model.Pet;
import de.neuefische.mucjava231petshelter.repo.OwnerScrvice;
import de.neuefische.mucjava231petshelter.repo.PetRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepo petRepo;
    private final OwnerScrvice ownerScrvice;

    public List<Pet> getAllPets(){
        return this.petRepo.findAll();
    }
    public Pet getPetById(String id) throws PetNotFoundExceptoin {
        return this.petRepo.findById(id).
                orElseThrow(() -> new PetNotFoundExceptoin("No Pet With this id: "+id));
    }

    public Pet createPet(Pet pet){
        return this.petRepo.save(pet);
    }

    public Pet updatePet(String id, Pet pet){
        pet = pet.withId(id);
        return this.petRepo.save(pet);
    }

    public void delete(String id){
        this.petRepo.deleteById(id);
    }

    public List<Pet> findAllBySpecies(String species){
        return this.petRepo.findAllBySpecies(species);
    }

    public List<Pet>  findPetByAgeMoreThen2YearsOrEquals2(Integer age){
        if(age >= 2){
            return this.petRepo.findAllByAge(age);
        }else {
            throw new IllegalArgumentException("Age musst be older then: "+age);
        }
    }

    public List<Pet>  findAllByNameStartingWith(String prefix){
        return this.petRepo.findByNameStartingWithIgnoreCase(prefix);
    }

    public List<Pet> findAllByOwnerId(String ownerId){
        return this.petRepo.findAllByOwnerId(ownerId);
    }

    public List<Pet> findAllByOwnerName(String ownerName){
        Owner theOwner = this.ownerScrvice.findByName(ownerName).orElseThrow();
        return this.petRepo.findAllByOwnerId(theOwner.id());
    }
}
