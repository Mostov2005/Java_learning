package org.knit.solutions.Task20.passwordmanager.repository;

import org.knit.solutions.Task20.passwordmanager.model.PasswordEntry;

import java.util.List;

public interface PasswordRepository {
    void add(PasswordEntry entry);

    List<PasswordEntry> findAll();

    PasswordEntry findBySite(String site);

    void delete(String site);
}