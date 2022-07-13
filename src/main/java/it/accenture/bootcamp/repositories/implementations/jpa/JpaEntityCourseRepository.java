package it.accenture.bootcamp.repositories.implementations.jpa;

import it.accenture.bootcamp.daos.JpaGenericsRepository;
import it.accenture.bootcamp.models.Course;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;

@Repository
@Profile("jpa")
public class JpaEntityCourseRepository extends JpaGenericsRepository<Long, Course> {

    public JpaEntityCourseRepository(EntityManager em) {
        super(Course.class, em);
    }
}
