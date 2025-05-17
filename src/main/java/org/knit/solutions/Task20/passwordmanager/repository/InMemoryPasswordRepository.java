package org.knit.solutions.Task20.passwordmanager.repository;

import org.knit.solutions.Task20.passwordmanager.model.PasswordEntry;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class InMemoryPasswordRepository implements PasswordRepository {
    private final Map<String, PasswordEntry> entries = new HashMap<>();

    @Override
    public void add(PasswordEntry entry) {
        entries.put(entry.getSite(), entry);
    }

    @Override
    public List<PasswordEntry> findAll() {
        return new ArrayList<>(entries.values());
    }

    @Override
    public PasswordEntry findBySite(String site) {
        return entries.get(site);
    }

    @Override
    public void delete(String site) {
        entries.remove(site);
    }
}