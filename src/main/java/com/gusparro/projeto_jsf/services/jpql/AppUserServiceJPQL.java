package com.gusparro.projeto_jsf.services.jpql;

import com.gusparro.projeto_jsf.configs.exceptions.ServiceException;
import com.gusparro.projeto_jsf.models.AppUser;
import com.gusparro.projeto_jsf.repositories.jpql.AppUserRepositoryJPQL;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
@ApplicationScoped
public class AppUserServiceJPQL {

    @Inject
    private AppUserRepositoryJPQL repository;

    public AppUser save(AppUser entity) throws ServiceException {
        try {
            repository.beginTransaction();
            entity = repository.save(entity);
            repository.commitTransaction();

            return entity;
        } catch (Exception exception) {
            exception.printStackTrace();

            repository.rollbackTransaction();

            throw new ServiceException(exception.getMessage());
        }
    }

    public void remove(AppUser entity) throws ServiceException {
        try {
            repository.beginTransaction();
            repository.remove(entity);
            repository.commitTransaction();
        } catch (Exception exception) {
            exception.printStackTrace();

            repository.rollbackTransaction();

            throw new ServiceException(exception.getMessage());
        }
    }
    
    public void removeList(List<AppUser> entities) throws ServiceException {
        for (AppUser user: entities) {
            remove(user);
        }
    }

    public AppUser findById(Long id) throws ServiceException {
        return repository.findById(id).orElseThrow(() -> new ServiceException("User not found - " + id));
    }

    public AppUser findByEmail(String email) throws ServiceException {
        return repository.findByEmail(email).orElseThrow(() -> new ServiceException("User not found - " + email));
    }

    public List<AppUser> findAll() {
        return repository.findAll();
    }

    public List<AppUser> findAllByName(String name) {
        return repository.findAllByName(name);
    }

}
