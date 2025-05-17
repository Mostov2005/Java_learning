package org.knit.solutions.Task20.passwordmanager.service;

import org.knit.solutions.Task20.passwordmanager.clipboard.ClipboardService;
import org.knit.solutions.Task20.passwordmanager.crypto.EncryptionService;
import org.knit.solutions.Task20.passwordmanager.model.PasswordEntry;
import org.knit.solutions.Task20.passwordmanager.repository.PasswordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordService {
    private final PasswordRepository repository;
    private final EncryptionService encryptionService;
    private final ClipboardService clipboardService;

    public PasswordService(
            PasswordRepository repository,
            EncryptionService encryptionService,
            ClipboardService clipboardService) {
        this.repository = repository;
        this.encryptionService = encryptionService;
        this.clipboardService = clipboardService;
    }

    public void add(String site, String login, String plainPassword) {
        String encrypted = encryptionService.encrypt(plainPassword);
        PasswordEntry entry = new PasswordEntry(site, login, encrypted);
        repository.add(entry);
    }

    public List<PasswordEntry> list() {
        return repository.findAll();
    }

    public void delete(String site) {
        repository.delete(site);
    }

    public boolean copy(String site) {
        PasswordEntry entry = repository.findBySite(site);
        if (entry != null) {
            String decrypted = encryptionService.decrypt(entry.getEncryptedPassword());
            clipboardService.copyToClipboard(decrypted);
            return true;
        }
        return false;
    }
}