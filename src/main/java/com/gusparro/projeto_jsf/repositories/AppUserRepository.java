package com.gusparro.projeto_jsf.repositories;

import com.gusparro.projeto_jsf.models.AppUser;

public class AppUserRepository extends DefaultRepository<AppUser> {

    public AppUser findById(Long id) {
       return entityManager.find(AppUser.class,  id);
    }

}
