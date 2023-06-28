package de.neuefische.mucjava231petshelter.exception;

public record PetNotFoundResponse (
        String message,
        String status,
        long timeStamp
){


}
