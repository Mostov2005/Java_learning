package org.knit.solutions.Task20.passwordmanager.security;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MasterPasswordHolder {
    private char[] masterPassword;

    public void set(char[] masterPassword) {
        this.masterPassword = masterPassword;
    }

    public char[] get() {
        return masterPassword;
    }

    public void clear() {
        if (masterPassword != null) {
            Arrays.fill(masterPassword, '\0');
        }
    }
}