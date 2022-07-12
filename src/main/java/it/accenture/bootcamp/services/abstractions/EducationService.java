package it.accenture.bootcamp.services.abstractions;

import it.accenture.bootcamp.models.Classroom;

public interface EducationService {

    Iterable<Classroom> getAllClassrooms();
}
