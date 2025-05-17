package org.knit.solutions.Task20.passwordmanager.model;

public class PasswordEntry {
    private String site;
    private String login;
    private String encryptedPassword;

    public PasswordEntry(String site, String login, String encryptedPassword) {
        this.site = site;
        this.login = login;
        this.encryptedPassword = encryptedPassword;
    }

    public String getSite() {
        return site;
    }

    public String getLogin() {
        return login;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }
}