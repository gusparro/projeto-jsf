package com.gusparro.projeto_jsf.controllers.users;

import com.gusparro.projeto_jsf.configs.exceptions.ServiceException;
import com.gusparro.projeto_jsf.configs.utils.MessagesFactory;
import com.gusparro.projeto_jsf.configs.utils.PasswordHasher;
import com.gusparro.projeto_jsf.dtos.users.SignInDTO;
import com.gusparro.projeto_jsf.models.AppUser;
import com.gusparro.projeto_jsf.services.jpql.AppUserServiceJPQL;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;
import org.primefaces.PrimeFaces;

import java.io.Serializable;

@Model
public class SignInUserController implements Serializable {

    @Inject
    private AppUserServiceJPQL appUserServiceJPQL;

    private SignInDTO signInDTO;

    public String access() {
        try {
            AppUser appUser = appUserServiceJPQL.findByEmail(signInDTO.getEmail());

            if (validateAppUser(appUser)) {
                return "/home/index.xhtml?faces-redirect=true";
            }

            MessagesFactory.addErrorMessage("Email or password are invalid.");
            PrimeFaces.current().ajax().update("signIn_form:messages");
        } catch (Exception e) {
            e.printStackTrace();

            MessagesFactory.addErrorMessage("Email or password are invalid.");
            PrimeFaces.current().ajax().update("signIn_form:messages");
        }

        return null;
    }

    private boolean validateAppUser(AppUser appUser) {
        return appUser.getEmail().equals(signInDTO.getEmail())
                && PasswordHasher.verifyPassword(signInDTO.getPassword(), appUser.getPassword());
    }

    public SignInDTO getSignInDTO() {
        if (signInDTO == null) {
            signInDTO = new SignInDTO();
        }

        return signInDTO;
    }

    public void setSignInDTO(SignInDTO signInDTO) {
        this.signInDTO = signInDTO;
    }

}
