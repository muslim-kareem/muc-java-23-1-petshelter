package de.neuefische.mucjava231petshelter.controller;

import de.neuefische.mucjava231petshelter.model.Owner;
import de.neuefische.mucjava231petshelter.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;

    @GetMapping
    public List<Owner> findAll(){
        return this.ownerService.findAll();
    }


    @GetMapping("/{id}")
    public Owner findById(@PathVariable String id){
        return this.ownerService.findById(id);
    }

    @PostMapping
    public void createPet(@RequestBody Owner owner){
        this.ownerService.createOwner(owner);
    }
}
