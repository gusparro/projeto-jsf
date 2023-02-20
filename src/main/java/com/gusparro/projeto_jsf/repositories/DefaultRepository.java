package com.gusparro.projeto_jsf.repositories;

import com.gusparro.projeto_jsf.configs.PersistenceUnitInitialization;
import com.gusparro.projeto_jsf.configs.exceptions.RepositoryException;
import com.gusparro.projeto_jsf.models.DefaultEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class DefaultRepository<T extends DefaultEntity> {

    protected EntityManager entityManager;

    protected EntityTransaction entityTransaction;

    public DefaultRepository() {
        entityManager = PersistenceUnitInitialization.getEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    public T save(T entity) throws RepositoryException {
        try {
            return entityManager.merge(entity);
        } catch (Exception exception) {
            exception.printStackTrace();

            throw new RepositoryException(exception.getMessage());
        }
    }

    public void remove(T entity) throws RepositoryException {
        try {
            entity = save(entity);
            entityManager.remove(entity);
        } catch (Exception exception) {
            exception.printStackTrace();

            throw new RepositoryException(exception.getMessage());
        }
    }

    public void beginTransaction() {
        try {
            entityTransaction.begin();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void commitTransaction() {
        try {
            entityTransaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void rollbackTransaction() {
        try {
            entityTransaction.rollback();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
