package com.gusparro.projeto_jsf.controllers.users;

import com.gusparro.projeto_jsf.configs.exceptions.ServiceException;
import com.gusparro.projeto_jsf.models.AppUser;
import com.gusparro.projeto_jsf.services.jpql.AppUserServiceJPQL;
import jakarta.enterprise.inject.Model;

@Model
public class NewUserController {

    private final AppUserServiceJPQL appUserServiceJPQL;

    private AppUser appUser;

    public NewUserController() {
        appUserServiceJPQL = new AppUserServiceJPQL();
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

    public String save() {
        try {
            appUser = appUserServiceJPQL.save(appUser);
        } catch (ServiceException exception) {
            exception.printStackTrace();
        }

        return "";
    }

}
