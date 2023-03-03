package com.gusparro.projeto_jsf.configs.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceUnitInitialization {

    private static EntityManagerFactory factory;

    private PersistenceUnitInitialization() {
    }

    public static EntityManager getEntityManager() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("default");
        }

        return factory.createEntityManager();
    }

}
