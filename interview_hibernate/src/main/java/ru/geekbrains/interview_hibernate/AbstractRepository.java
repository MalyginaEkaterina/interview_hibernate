package ru.geekbrains.interview_hibernate;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class AbstractRepository<T, ID> {
    private final EntityManager em;

    private final Class<T> tClass;

    AbstractRepository(EntityManager em, Class<T> tClass) {
        this.em = em;
        this.tClass = tClass;
    }

   public T findById(ID id) {
        return em.find(tClass, id);
    }

    @Transactional
    public boolean deleteById(ID id) {
        T entity = findById(id);
        if (entity == null) {
            return false;
        } else {
            em.remove(entity);
            return true;
        }
    }

    @Transactional
    public T insert(T entity) {
        em.persist(entity);
        return entity;
    }

    @Transactional
    public T update(T entity) {
        em.merge(entity);
        return entity;
    }

    public List<T> findAll() {
        return em.createQuery(String.format("SELECT e from %s e", tClass.getSimpleName()))
                .getResultList();
    }
}
