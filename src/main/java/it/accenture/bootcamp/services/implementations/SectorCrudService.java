
package it.accenture.bootcamp.services.implementations;

import it.accenture.bootcamp.models.Sector;
import it.accenture.bootcamp.repositories.abstractions.SectorRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SectorCrudService extends CrudService<Sector, Long, SectorRepository> {

    public SectorCrudService(SectorRepository repo) {
        super(repo, Sector.class);
    }
}
