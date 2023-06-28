package de.neuefische.mucjava231petshelter.controller;

import de.neuefische.mucjava231petshelter.exception.PetNotFoundExceptoin;
import de.neuefische.mucjava231petshelter.model.Pet;
import de.neuefische.mucjava231petshelter.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pets")
public class PetController {

    private final PetService petService;

    @GetMapping
    public List<Pet> findAll(){
        return this.petService.getAllPets();
    }
  @GetMapping("/{id}")
    public Pet findPetById(@PathVariable String id) throws PetNotFoundExceptoin {
        return this.petService.getPetById(id);
    }

    @GetMapping("/search")
    public List<Pet> findPetBySpecies(@RequestParam String species){
       return this.petService.findAllBySpecies(species);
    }

    @GetMapping("/search-by-age")
    public List<Pet> findPetByAgeMoreThen2Years(@RequestParam Integer age){
       return this.petService.findPetByAgeMoreThen2YearsOrEquals2(age);
    }
    @GetMapping("/search-by-name-start-with")
    public List<Pet> findAllByNameStartingWith(@RequestParam String namePrefix){
       return this.petService.findAllByNameStartingWith(namePrefix);
    }

    @GetMapping("/search-by-owner-name")
    public List<Pet> findByOwnerName(@RequestParam String ownerName){
        return this.petService.findAllByOwnerName(ownerName);
    }

    @PostMapping
    public void createPet(@RequestBody Pet pet){
        this.petService.createPet(pet);
    }

    @GetMapping("/owner/{id}")
    public List<Pet> findByOwnerId(@PathVariable String id){
        return this.petService.findAllByOwnerId(id);
    }

}
