package com.gusparro.projeto_jsf.controllers.users;

import com.gusparro.projeto_jsf.configs.exceptions.ServiceException;
import com.gusparro.projeto_jsf.configs.utils.MessagesFactory;
import com.gusparro.projeto_jsf.models.AppUser;
import com.gusparro.projeto_jsf.services.jpql.AppUserServiceJPQL;
import jakarta.annotation.PostConstruct;
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
        selectedUser = new AppUser();
    }

    public void saveUser() {
        if (selectedUser.getId() == null) {
            try {
                selectedUser = appUserServiceJPQL.save(selectedUser);
            } catch (ServiceException e) {
                e.printStackTrace();

                MessagesFactory.addErrorMessage("User Failed");
            }

            users.add(selectedUser);

            MessagesFactory.addInfoMessage("User Created");
        } else {
            try {
                selectedUser = appUserServiceJPQL.save(selectedUser);
            } catch (ServiceException e) {
                e.printStackTrace();

                MessagesFactory.addErrorMessage("User Failed");
            }

            MessagesFactory.addInfoMessage("User Updated");
        }

        PrimeFaces.current().executeScript("PF('manageUserDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-users");
    }

    public void deleteUser() {
        try {
            appUserServiceJPQL.remove(selectedUser);
            users = appUserServiceJPQL.findAll();
            selectedUser = null;

            MessagesFactory.addInfoMessage("User Removed");
            PrimeFaces.current().ajax().update("form:messages", "form:dt-users");
        } catch (ServiceException e) {
            e.printStackTrace();

            MessagesFactory.addErrorMessage("User could not be removed.");
        }
    }

    public void deleteSelectedUsers() {
        try {
            appUserServiceJPQL.removeList(selectedUsers);
            users = appUserServiceJPQL.findAll();
            selectedUsers = null;

            MessagesFactory.addInfoMessage("Users Removed");
            PrimeFaces.current().ajax().update("form:messages", "form:dt-users");
        } catch (ServiceException e) {
            e.printStackTrace();

            MessagesFactory.addErrorMessage("Users could not be removed.");
        }
    }

    public void searchUsers() {
        String searchQuery = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("value");
        users = appUserServiceJPQL.findAllByName(searchQuery);

        PrimeFaces.current().ajax().update("form:dt-users");
    }

    public boolean hasSelectedUsers() {
        return selectedUsers != null && !selectedUsers.isEmpty();
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedUsers()) {
            int size = selectedUsers.size();
            return size > 1 ? size + " users selected" : "1 user selected";
        }

        return "Delete";
    }

}
