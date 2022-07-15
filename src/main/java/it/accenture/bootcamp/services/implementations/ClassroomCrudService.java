package it.accenture.bootcamp.services.implementations;

import it.accenture.bootcamp.models.Classroom;
import it.accenture.bootcamp.repositories.abstractions.ClassroomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ClassroomCrudService extends CrudService<Classroom, Long, ClassroomRepository> {

    public ClassroomCrudService(ClassroomRepository repo) {
        super(repo, Classroom.class);
    }
}