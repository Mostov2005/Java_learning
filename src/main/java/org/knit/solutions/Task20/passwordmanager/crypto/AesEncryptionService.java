package org.knit.solutions.Task20.passwordmanager.crypto;

import org.knit.solutions.Task20.passwordmanager.security.MasterPasswordHolder;
import org.springframework.stereotype.Component;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

@Component
public class AesEncryptionService implements EncryptionService {
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final int KEY_SIZE = 256;
    private static final int ITERATIONS = 65536;
    private static final int SALT_LENGTH = 16;
    private static final int IV_LENGTH = 16;

    private final MasterPasswordHolder masterPasswordHolder;

    public AesEncryptionService(MasterPasswordHolder masterPasswordHolder) {
        this.masterPasswordHolder = masterPasswordHolder;
    }

    @Override
    public String encrypt(String plainText) {
        try {
            byte[] salt = generateRandomBytes(SALT_LENGTH);
            byte[] iv = generateRandomBytes(IV_LENGTH);
            SecretKeySpec key = deriveKey(salt);

            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
            byte[] encrypted = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));

            // Составляем результат: salt + iv + encrypted
            byte[] combined = new byte[salt.length + iv.length + encrypted.length];
            System.arraycopy(salt, 0, combined, 0, salt.length);
            System.arraycopy(iv, 0, combined, salt.length, iv.length);
            System.arraycopy(encrypted, 0, combined, salt.length + iv.length, encrypted.length);

            return Base64.getEncoder().encodeToString(combined);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при шифровании", e);
        }
    }

    @Override
    public String decrypt(String encryptedText) {
        try {
            byte[] allBytes = Base64.getDecoder().decode(encryptedText);
            byte[] salt = new byte[SALT_LENGTH];
            byte[] iv = new byte[IV_LENGTH];
            byte[] encrypted = new byte[allBytes.length - SALT_LENGTH - IV_LENGTH];

            System.arraycopy(allBytes, 0, salt, 0, SALT_LENGTH);
            System.arraycopy(allBytes, SALT_LENGTH, iv, 0, IV_LENGTH);
            System.arraycopy(allBytes, SALT_LENGTH + IV_LENGTH, encrypted, 0, encrypted.length);

            SecretKeySpec key = deriveKey(salt);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));

            byte[] decrypted = cipher.doFinal(encrypted);
            return new String(decrypted, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при дешифровке", e);
        }
    }

    private SecretKeySpec deriveKey(byte[] salt) throws Exception {
        PBEKeySpec spec = new PBEKeySpec(masterPasswordHolder.get(), salt, ITERATIONS, KEY_SIZE);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] keyBytes = factory.generateSecret(spec).getEncoded();
        return new SecretKeySpec(keyBytes, "AES");
    }

    private byte[] generateRandomBytes(int length) {
        byte[] bytes = new byte[length];
        new SecureRandom().nextBytes(bytes);
        return bytes;
    }
}