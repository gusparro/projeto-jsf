package com.gusparro.projeto_jsf.controllers.users;

import com.gusparro.projeto_jsf.configs.exceptions.ServiceException;
import com.gusparro.projeto_jsf.models.AppUser;
import com.gusparro.projeto_jsf.services.jpql.AppUserServiceJPQL;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;

import java.io.Serializable;

@Model
public class SignInUserController implements Serializable {

    @Inject
    private AppUserServiceJPQL appUserServiceJPQL;

    private AppUser appUser;

    public String access() {
        return "/home/index.xhtml?faces-redirect=true";
    }

    public AppUser getAppUser() {
        if (appUser == null) {
            appUser = new AppUser();
        }

        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

}
