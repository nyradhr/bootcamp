package it.accenture.bootcamp.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return classroomRepo.getAll();
    }

}
