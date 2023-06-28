package de.neuefische.mucjava231petshelter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PetNotFoundExceptoin.class)
    public ResponseEntity<PetNotFoundResponse> handelPetNotFoundException(PetNotFoundExceptoin ex){
        PetNotFoundResponse petResponse = new PetNotFoundResponse(
                                                        ex.getMessage(),
                                                        HttpStatus.NOT_FOUND.toString(),
                                                        System.currentTimeMillis()
                                                         );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(petResponse);
    }

}
