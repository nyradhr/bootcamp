package it.accenture.bootcamp.repositories.abstractions;

import it.accenture.bootcamp.models.Classroom;

public interface ClassroomRepository {

    Iterable<Classroom> getAll();
}
