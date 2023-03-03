package com.gusparro.projeto_jsf.configs.utils;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class PasswordHasher {

    public static String hashPassword(String password) {
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        return passwordEncryptor.encryptPassword(password);
    }

    public static boolean verifyPassword(String password, String encryptedPassword) {
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        return passwordEncryptor.checkPassword(password, encryptedPassword);
    }

}
