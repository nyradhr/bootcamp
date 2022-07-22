package it.accenture.bootcamp.services.implementations;

import it.accenture.bootcamp.models.Edition;
import it.accenture.bootcamp.repositories.abstractions.EditionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditionService extends CrudService<Edition, Long, EditionRepository>{

    public EditionService(EditionRepository repo) {
        super(repo, Edition.class);
    }

    public List<Edition> findByCourseId(long id) {
        return repo.findByCourseId(id);
    }

    public List<Edition> findTop4ByOrderByStartDateDesc() {
        return repo.findTop4ByOrderByStartDateDesc();
    }




}
