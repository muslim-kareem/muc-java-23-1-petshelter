package de.neuefische.mucjava231petshelter.pet;

public record Pet(
        String id,
        String name,
        int age,
        String species,
        String ownerId

) {

    public Pet withId(String id){
        return new Pet(id,this.name,this.age,this.species,this.ownerId);
    }
}
