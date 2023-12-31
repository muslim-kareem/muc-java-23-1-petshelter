package de.neuefische.mucjava231petshelter.service;

import de.neuefische.mucjava231petshelter.model.Owner;
import de.neuefische.mucjava231petshelter.model.Pet;
import de.neuefische.mucjava231petshelter.repo.OwnerScrvice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerScrvice ownerRepo;
    public final PetService petService;

    public List<Owner> findAll(){
        return this.ownerRepo.findAll();
    }

    public Owner findById(String id){
        List<Pet> petsWithOwnerId = this.petService.findAllByOwnerId(id);
        Optional<Owner> ownerOptional = this.ownerRepo.findById(id);
        Owner theOwner;

        if(ownerOptional.isPresent()){
            theOwner = ownerOptional.get();
            theOwner = theOwner.withPets(petsWithOwnerId);
        }else {
            throw new NoSuchElementException("No Owner with this Id: "+id);
        }

        return theOwner;
    }

    public void createOwner(Owner owner){
        this.ownerRepo.save(owner);
    }

    public Owner findOwnerByName(String name){
        return  this.ownerRepo.findByName(name).orElseThrow();
    }

}
