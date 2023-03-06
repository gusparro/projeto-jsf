package com.gusparro.projeto_jsf.controllers.users;

import com.gusparro.projeto_jsf.configs.exceptions.ServiceException;
import com.gusparro.projeto_jsf.models.AppUser;
import com.gusparro.projeto_jsf.services.jpql.AppUserServiceJPQL;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.Model;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class UsersController implements Serializable {

    @Inject
    private AppUserServiceJPQL appUserServiceJPQL;

    @Getter
    @Setter
    private List<AppUser> users;

    @Getter
    @Setter
    private AppUser selectedUser;

    @Getter
    @Setter
    private List<AppUser> selectedUsers;

    @PostConstruct
    public void init() {
        users = appUserServiceJPQL.findAll();
    }

    public void openNew() {
        this.selectedUser = new AppUser();
    }

    public void saveUser() {
        // TODO
        // Implementar a logica
        if (this.selectedUser.getId() == null) {
            try {
                this.selectedUser = appUserServiceJPQL.save(selectedUser);
            } catch (ServiceException e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User Failed"));
            }
            this.users.add(this.selectedUser);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User Added"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User Updated"));
        }

        PrimeFaces.current().executeScript("PF('manageUserDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-users");
    }

    public void deleteUser() {
        // TODO
        // Implementar a logica
        this.users.remove(this.selectedUsers);
        this.selectedUsers.remove(this.selectedUser);
        this.selectedUser = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-users");
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedUsers()) {
            int size = this.selectedUsers.size();
            return size > 1 ? size + " users selected" : "1 user selected";
        }

        return "Delete";
    }

    public boolean hasSelectedUsers() {
        return this.selectedUsers != null && !this.selectedUsers.isEmpty();
    }

    public void deleteSelectedUsers() {
        // TODO
        // Implementar a logica
        this.users.removeAll(this.selectedUsers);
        this.selectedUsers = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Users Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-users");
        PrimeFaces.current().executeScript("PF('dtUsers').clearFilters()");
    }

}
