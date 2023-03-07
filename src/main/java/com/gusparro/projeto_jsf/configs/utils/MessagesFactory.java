package com.gusparro.projeto_jsf.configs.utils;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

public class MessagesFactory {

    public static void addErrorMessage(String message) {
        FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }

    public static void addWarningMessage(String message) {
        FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, message, null));
    }

    public static void addInfoMessage(String message) {
        FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
    }

}
