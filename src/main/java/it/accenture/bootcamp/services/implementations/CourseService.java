
package it.accenture.bootcamp.services.implementations;

import it.accenture.bootcamp.models.Course;
import it.accenture.bootcamp.models.Edition;
import it.accenture.bootcamp.repositories.abstractions.CourseRepository;
import it.accenture.bootcamp.repositories.abstractions.EditionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService extends CrudService<Course, Long, CourseRepository> {

    private EditionRepository editionRepo;

    public CourseService(CourseRepository repo, EditionRepository editionRepo) {
        super(repo, Course.class);
        this.editionRepo = editionRepo;
    }

    public Iterable<Course> findBySectorName(String sectorName) {
        return repo.findBySectorName(sectorName);
    }

    public Iterable<Course> findByTitleContaining(String like) {
        return repo.findByTitleContainingIgnoreCase(like);
    }

    public List<Edition> findEditionsByCourse(long id) {
        return editionRepo.findByCourseId(id);
    }
}

