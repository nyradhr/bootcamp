package it.accenture.bootcamp.repositories.abstractions;

import it.accenture.bootcamp.models.Course;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Profile("jpa")
public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByTitle(String title);
    List<Course> findBySectorName(String sectorName);
    //List<Course> findBySectorNameAndTitleLike(String sectorName, String like);
    List<Course> findByTitleContainingIgnoreCase(String like);
    List<Course> findByDurationGreaterThanAndCostLessThan(int duration, int cost);
    @Query("SELECT c FROM Course c WHERE c.title NOT IN (SELECT e.course.title FROM Edition e)")
    List<Course> findByNoEdition();


}