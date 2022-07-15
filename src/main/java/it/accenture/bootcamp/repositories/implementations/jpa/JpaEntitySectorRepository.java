package it.accenture.bootcamp.repositories.implementations.jpa;

import it.accenture.bootcamp.models.Sector;

import javax.persistence.EntityManager;


public class JpaEntitySectorRepository extends JpaGenericsRepository<Sector, Long> {

    public JpaEntitySectorRepository(EntityManager em) {
        super(Sector.class, em);
    }
}

