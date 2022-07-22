package it.accenture.bootcamp.repositories.abstractions;

import it.accenture.bootcamp.models.Edition;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("jpa")
public interface EditionRepository extends JpaRepository<Edition, Long> {
    @Query("SELECT e FROM Edition e WHERE e.course.id = :id")
    List<Edition> findByCourseId(@Param("id") long id);

    List<Edition> findTop4ByOrderByStartDateDesc();

}
