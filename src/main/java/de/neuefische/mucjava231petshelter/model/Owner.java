package de.neuefische.mucjava231petshelter.model;

import java.util.List;

public record Owner(
        String id,
        String name,
        List<Pet> pets
) {

    public Owner withPets(List<Pet> pets){
       return new Owner(this.id,this.name,pets);
    }
}
