package it.accenture.bootcamp.services.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.accenture.bootcamp.exceptions.EntityNotFoundException;
import it.accenture.bootcamp.models.Classroom;
import it.accenture.bootcamp.repositories.abstractions.ClassroomRepository;
import it.accenture.bootcamp.services.abstractions.EducationService;

@Service
public class EducationServiceImpl implements EducationService {
    private ClassroomRepository classroomRepo;
    public static final String ERROR_NOT_FOUND = "L'entità %s con id %d non esiste";

    @Autowired
    public EducationServiceImpl(ClassroomRepository classroomRepo) {
        this.classroomRepo = classroomRepo;
    }

    @Override
    public Iterable<Classroom> getAllClassrooms() {
        return classroomRepo.findAll();
    }

    @Transactional
    @Override
    public void deleteClassroom(Classroom c) throws EntityNotFoundException {
        if (classroomExists(c.getId())) {
            classroomRepo.delete(c);
        } else {
            throw new EntityNotFoundException(ERROR_NOT_FOUND, Classroom.class, c.getId());
        }

    }

    @Transactional
    @Override
    public void deleteClassroomById(long id) throws EntityNotFoundException {
        if (classroomExists(id)) {
            classroomRepo.deleteById(id);
            ;
        } else {
            throw new EntityNotFoundException(ERROR_NOT_FOUND, Classroom.class, id);
        }

    }

    @Override
    public Optional<Classroom> findClassroomById(long id) {
        return classroomRepo.findById(id);
    }

    @Transactional
    @Override
    public Classroom saveOrUpdateClassroom(Classroom c) throws EntityNotFoundException {
        if (c.getId() != 0 && !classroomExists(c.getId())) {
            throw new EntityNotFoundException(ERROR_NOT_FOUND, Classroom.class, c.getId());
        }
        return classroomRepo.save(c);
    }

    @Override
    public boolean classroomExists(long id) {
        return classroomRepo.existsById(id);
    }

}
