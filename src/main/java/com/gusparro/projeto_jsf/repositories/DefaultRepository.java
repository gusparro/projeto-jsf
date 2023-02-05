package com.gusparro.projeto_jsf.repositories;

import com.gusparro.projeto_jsf.configs.PersistenceUnitInitialization;
import com.gusparro.projeto_jsf.models.DefaultEntity;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class DefaultRepository<T extends DefaultEntity> {

    protected EntityManager entityManager;

    public DefaultRepository() {
        entityManager = PersistenceUnitInitialization.getEntityManager();
    }

    public T save(T entity) throws Exception {
        try {
            return entityManager.merge(entity);
        } catch (Exception e) {
            e.printStackTrace();

            throw new Exception(e.getMessage());
        }
    }

    public void remove(T entity) throws Exception {
        try {
            T t = entityManager.merge(entity);
            entityManager.remove(t);
        } catch (Exception e) {
            e.printStackTrace();

            throw new Exception(e.getMessage());
        }
    }

    public void beginTransaction() {
        try {
            entityManager.getTransaction().begin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void commitTransaction() {
        try {
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rollbackTransaction() {
        try {
            entityManager.getTransaction().rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
