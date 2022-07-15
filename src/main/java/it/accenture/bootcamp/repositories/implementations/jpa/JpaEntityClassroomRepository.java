package it.accenture.bootcamp.repositories.implementations.jpa;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import it.accenture.bootcamp.models.Classroom;
import it.accenture.bootcamp.repositories.abstractions.ClassroomRepository;


public class JpaEntityClassroomRepository implements ClassroomRepository {

    private EntityManager em;

    public JpaEntityClassroomRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Classroom> findAll() {
        System.out.println("Using Jpa Repo!");
        List<Classroom> cl = em.createQuery("FROM CLASSROOM", Classroom.class)
                .getResultList();
        return cl;
    }
    @Override
    public <S extends Classroom> boolean exists(Example<S> example) {
        return false;
    }
    @Override
    public boolean existsById(Long aLong) {
        return false;
    }
    @Override
    public Optional<Classroom> findById(Long id) {
        Classroom c = em.find(Classroom.class, id);
        return c == null ? Optional.empty() : Optional.of(c);
    }
    @Override
    public void delete(Classroom entity) {
        em.remove(entity);
    }
    @Override
    public void deleteById(Long id) {
        Query q = em.createQuery("DELETE FROM CLASSROOM WHERE ID = :id");
        q.setParameter("ID", id);
        q.executeUpdate();
    }
    @Override
    public <S extends Classroom> S save(S entity) {
        S cr = em.merge(entity);
        return cr;
    }
//    @Override
//    public Iterable<Classroom> findAll() {
//        System.out.println("Using Jpa Repo!");
//        List<Classroom> cl = em.createQuery("from Classroom", Classroom.class)
//                .getResultList();
//        return cl;
//    }
//    @Override
//    public void delete(Classroom c) {
//        em.remove(c);
//    }
//    @Override
//    public void deleteById(long id) {
//        Query q = em.createQuery("DELETE FROM Classroom WHERE id=:id");
//        q.setParameter("id", id);
//        q.executeUpdate();
//    }
//    @Override
//    public Optional<Classroom> findById(long id) {
//        Classroom c = em.find(Classroom.class, id);
//        return c == null ? Optional.empty() : Optional.of(c);
//    }
//    @Override
//    public Classroom save(Classroom c) {
//        Classroom cr = em.merge(c);
//        return cr;
//    }
//    @Override
//    public boolean existsById(long id) {
//        return findById(id).isPresent();
//    }
    @Override
    public List<Classroom> findAll(Sort sort) {
        return null;
    }
    @Override
    public Page<Classroom> findAll(Pageable pageable) {
        return null;
    }
    @Override
    public List<Classroom> findAllById(Iterable<Long> longs) {
        return null;
    }
    @Override
    public long count() {
        return 0;
    }
    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }
    @Override
    public void deleteAll(Iterable<? extends Classroom> entities) {

    }
    @Override
    public void deleteAll() {

    }
    @Override
    public <S extends Classroom> List<S> saveAll(Iterable<S> entities) {
        return null;
    }
    @Override
    public void flush() {

    }
    @Override
    public <S extends Classroom> S saveAndFlush(S entity) {
        return null;
    }
    @Override
    public <S extends Classroom> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }
    @Override
    public void deleteAllInBatch(Iterable<Classroom> entities) {

    }
    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }
    @Override
    public void deleteAllInBatch() {

    }
    @Override
    public Classroom getOne(Long aLong) {
        return null;
    }
    @Override
    public Classroom getById(Long aLong) {
        return null;
    }
    @Override
    public Classroom getReferenceById(Long aLong) {
        return null;
    }
    @Override
    public <S extends Classroom> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }
    @Override
    public <S extends Classroom> List<S> findAll(Example<S> example) {
        return null;
    }
    @Override
    public <S extends Classroom> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }
    @Override
    public <S extends Classroom> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }
    @Override
    public <S extends Classroom> long count(Example<S> example) {
        return 0;
    }
    @Override
    public <S extends Classroom, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
