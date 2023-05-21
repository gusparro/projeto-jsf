package com.gusparro.projeto_jsf.repositories.jpql;

import com.gusparro.projeto_jsf.models.AppUser;
import com.gusparro.projeto_jsf.repositories.DefaultRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

@Named
@ApplicationScoped
public class AppUserRepositoryJPQL extends DefaultRepository<AppUser> {

    private String jpql;

    private AppUser appUser;

    private List<AppUser> appUsers;

    private TypedQuery<AppUser> query;

    public Optional<AppUser> findById(Long id) {
        jpql = "SELECT ap FROM AppUser ap WHERE ap.id = :id";

        query = entityManager.createQuery(jpql, AppUser.class);
        query.setParameter("id", id);

        appUser = query.getSingleResult();

        return Optional.ofNullable(appUser);
    }

    public Optional<AppUser> findByEmail(String email) {
        jpql = "SELECT ap FROM AppUser ap WHERE ap.email = :email";

        query = entityManager.createQuery(jpql, AppUser.class);
        query.setParameter("email", email);

        appUser = query.getSingleResult();

        return Optional.ofNullable(appUser);
    }

    public List<AppUser> findAll() {
        jpql = "SELECT ap FROM AppUser ap";

        query = entityManager.createQuery(jpql, AppUser.class);

        appUsers = query.getResultList();

        return appUsers;
    }

    public List<AppUser> findAllByName(String name) {
        jpql = "SELECT ap FROM AppUser ap WHERE UPPER(ap.name) LIKE UPPER(CONCAT('%', :name, '%'))";

        query = entityManager.createQuery(jpql, AppUser.class);
        query.setParameter("name", name);

        appUsers = query.getResultList();

        return appUsers;
    }

}
