package com.gusparro.projeto_jsf.controllers.users;

import com.gusparro.projeto_jsf.configs.exceptions.ServiceException;
import com.gusparro.projeto_jsf.models.AppUser;
import com.gusparro.projeto_jsf.services.jpql.AppUserServiceJPQL;
import jakarta.enterprise.inject.Model;

import java.io.Serializable;

@Model
public class NewUserController implements Serializable {

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
        System.out.println("Dentro do metodo");
        try {
            System.out.println("Antes do save");
            appUser = appUserServiceJPQL.save(appUser);
            System.out.println("Depois do save");
        } catch (ServiceException exception) {
            exception.printStackTrace();
        }

        return "";
    }

}
