package it.accenture.bootcamp.repositories.abstractions;

import java.util.Optional;

import it.accenture.bootcamp.models.Classroom;

public interface ClassroomRepository {

    Iterable<Classroom> findAll();

    void delete(Classroom c);

    void deleteById(long id);

    Optional<Classroom> findById(long id);

    Classroom save(Classroom c);

    boolean existsById(long id);
}
