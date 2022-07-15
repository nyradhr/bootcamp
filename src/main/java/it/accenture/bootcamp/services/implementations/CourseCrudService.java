
package it.accenture.bootcamp.services.implementations;

import it.accenture.bootcamp.models.Course;
import it.accenture.bootcamp.repositories.abstractions.CourseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseCrudService extends CrudService<Course, Long, CourseRepository> {

    public CourseCrudService(CourseRepository repo) {
        super(repo, Course.class);
    }
}

