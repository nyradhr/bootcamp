package it.accenture.bootcamp.repositories.abstractions;

import it.accenture.bootcamp.models.Edition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditionRepository extends JpaRepository<Edition, Long> {
}
