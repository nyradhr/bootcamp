package it.accenture.bootcamp.services.abstractions;

import java.util.Optional;

import it.accenture.bootcamp.exceptions.EntityNotFoundException;
import it.accenture.bootcamp.models.Classroom;

public interface EducationService {

    Iterable<Classroom> getAllClassrooms();

    void deleteClassroom(Classroom c) throws EntityNotFoundException;

    void deleteClassroomById(long id) throws EntityNotFoundException;

    Optional<Classroom> findClassroomById(long id);

    Classroom saveOrUpdateClassroom(Classroom c);

    boolean classroomExists(long id);
}
