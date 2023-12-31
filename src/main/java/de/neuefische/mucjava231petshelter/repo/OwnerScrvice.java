package de.neuefische.mucjava231petshelter.repo;

import de.neuefische.mucjava231petshelter.model.Owner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerScrvice extends MongoRepository<Owner, String> {

    Optional<Owner> findByName(String ownerName);
}
