package de.neuefische.mucjava231petshelter.owner;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepo extends MongoRepository<Owner, String> {

    Optional<Owner> findByName(String ownerName);
}
