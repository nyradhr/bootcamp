package it.accenture.bootcamp.repositories.implementations.jpa;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import it.accenture.bootcamp.models.Classroom;
import it.accenture.bootcamp.repositories.abstractions.ClassroomRepository;

@Repository
@Profile("jpa")
public class JpaEntityClassroomRepository implements ClassroomRepository {

    private EntityManager em;

    public JpaEntityClassroomRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Iterable<Classroom> findAll() {
        System.out.println("Using Jpa Repo!");
        List<Classroom> cl = em.createQuery("from Classroom", Classroom.class)
                .getResultList();
        return cl;
    }

    @Override
    public void delete(Classroom c) {
        em.remove(c);
    }

    @Override
    public void deleteById(long id) {
        Query q = em.createQuery("DELETE FROM Classroom WHERE id=:id");
        q.setParameter("id", id);
        q.executeUpdate();
    }

    @Override
    public Optional<Classroom> findById(long id) {
        Classroom c = em.find(Classroom.class, id);
        return c == null ? Optional.empty() : Optional.of(c);
    }

    @Override
    public Classroom save(Classroom c) {
        Classroom cr = em.merge(c);
        return cr;
    }

    @Override
    public boolean existsById(long id) {
        return findById(id).isPresent();
    }

}
