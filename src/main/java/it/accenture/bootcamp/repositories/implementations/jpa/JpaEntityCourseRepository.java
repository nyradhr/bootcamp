package it.accenture.bootcamp.repositories.implementations.jpa;

import it.accenture.bootcamp.models.Course;

import javax.persistence.EntityManager;


public class JpaEntityCourseRepository extends JpaGenericsRepository<Course, Long> {

    public JpaEntityCourseRepository(EntityManager em) {
        super(Course.class, em);
    }
}
