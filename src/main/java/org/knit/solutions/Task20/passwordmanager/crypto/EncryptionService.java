package org.knit.solutions.Task20.passwordmanager.crypto;

public interface EncryptionService {
    String encrypt(String plainText);
    String decrypt(String encryptedText);
}
