package it.accenture.bootcamp.repositories.implementations.jpa;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import it.accenture.bootcamp.repositories.abstractions.GenericsRepository;

public class JpaGenericsRepository<T, K> implements GenericsRepository<T, K> {

    protected Class<?> entityClass;
    protected EntityManager em;

    public JpaGenericsRepository(Class<?> entityClass, EntityManager em) {
        this.entityClass = entityClass;
        this.em = em;
    }

    @Override
    public Iterable<T> findAll() {
        @SuppressWarnings("unchecked")
        List<T> cl = (List<T>) em.createQuery(String.format("from %s", entityClass.getSimpleName()), entityClass)
                .getResultList();
        return cl;
    }

    @Override
    public void delete(T c) {
        em.remove(c);
    }

    @Override
    public void deleteById(K id) {
        // TODO Auto-generated method stub

    }

    @Override
    public Optional<T> findById(K id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public T save(T c) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean existsById(K id) {
        // TODO Auto-generated method stub
        return false;
    }

}
