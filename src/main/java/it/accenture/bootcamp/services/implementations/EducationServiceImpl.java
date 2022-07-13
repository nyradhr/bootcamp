package it.accenture.bootcamp.services.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.accenture.bootcamp.exceptions.EntityNotFoundException;
import it.accenture.bootcamp.models.Classroom;
import it.accenture.bootcamp.repositories.abstractions.ClassroomRepository;
import it.accenture.bootcamp.services.abstractions.EducationService;

@Service
public class EducationServiceImpl implements EducationService {
    private ClassroomRepository classroomRepo;

    @Autowired
    public EducationServiceImpl(ClassroomRepository classroomRepo) {
        this.classroomRepo = classroomRepo;
    }

    @Override
    public Iterable<Classroom> getAllClassrooms() {
        return classroomRepo.findAll();
    }

    @Override
    public void deleteClassroom(Classroom c) throws EntityNotFoundException {
        if (classroomExists(c.getId())) {
            classroomRepo.delete(c);
        } else {
            throw new EntityNotFoundException("l'entity %s non esiste", Classroom.class);
        }

    }

    @Override
    public void deleteClassroomById(long id) throws EntityNotFoundException {
        if (classroomExists(id)) {
            classroomRepo.deleteById(id);
            ;
        } else {
            throw new EntityNotFoundException("l'entity %s non esiste", Classroom.class);
        }

    }

    @Override
    public Optional<Classroom> findClassroomById(long id) {
        return classroomRepo.findById(id);
    }

    @Override
    public Classroom saveOrUpdateClassroom(Classroom c) {
        return classroomRepo.save(c);
    }

    @Override
    public boolean classroomExists(long id) {
        return classroomRepo.existsById(id);
    }

}
