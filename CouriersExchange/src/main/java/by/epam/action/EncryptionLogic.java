package by.epam.action;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class EncryptionLogic {

    public static byte[][] encrypt(String password) {

        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            byte[] passwordHash = md.digest(password.getBytes(StandardCharsets.UTF_8));

            byte[][] pair = new byte[2][];
            pair[0] = passwordHash;
            pair[1] = salt;

            return pair;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static byte[] encrypt(String password, byte[] salt) {

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);

            return md.digest(password.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}