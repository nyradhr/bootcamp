package it.accenture.bootcamp.services.implementations;

import it.accenture.bootcamp.daos.GenericsRepository;
import it.accenture.bootcamp.exceptions.EntityNotFoundException;
import it.accenture.bootcamp.models.DBModel;
import it.accenture.bootcamp.services.abstractions.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class Service /*implements EducationService<DBModel>*/ {
/*
    private GenericsRepository<Long, DBModel> repo;
    public static final String ERROR_NOT_FOUND = "L'entità %s con id %d non esiste";


    @Autowired
    public Service(GenericsRepository<Long, DBModel> repo) {
        this.repo = repo;
    }

    @Override
    public Iterable<DBModel> getAll() {
        return this.repo.findAll();
    }

    @Transactional
    @Override
    public void delete(DBModel m) throws EntityNotFoundException {
        if(exists(m.getId())){
            repo.delete(m);
        } else {
            throw new EntityNotFoundException(ERROR_NOT_FOUND, DBModel.class, m.getId());
        }
    }

    @Transactional
    @Override
    public void deleteById(long id) throws EntityNotFoundException {
        if (exists(id)) {
            repo.deleteById(id);
        } else {
            throw new EntityNotFoundException(ERROR_NOT_FOUND, DBModel.class, id);
        }
    }

    @Override
    public Optional<DBModel> findById(long id) {
        return repo.findById(id);
    }

    @Transactional
    @Override
    public DBModel saveOrUpdate(DBModel m) throws EntityNotFoundException {
        if (m.getId() != 0 && !exists(m.getId())) {
            throw new EntityNotFoundException(ERROR_NOT_FOUND, DBModel.class, m.getId());
        }
        return repo.save(m);
    }

    @Override
    public boolean exists(long id) {
        return repo.existsById(id);
    }

 */
}
