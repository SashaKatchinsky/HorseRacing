package by.epam.java.horse_racing.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.KeySpec;

public class PasswordHasher {
    private static class PasswordHasherHolder {
        private static final PasswordHasher INSTANCE = new PasswordHasher();
    }
    private static final Logger LOGGER = LogManager.getLogger(PasswordHasher.class.getName());
    private String salt = "banana";
    String algorithm = "PBKDF2WithHmacSHA1";
    int derivedKeyLength = 64;
    int iterations = 1000;

    private PasswordHasher() {

    }

    public static PasswordHasher getInstance() {
        return PasswordHasherHolder.INSTANCE;
    }

    public String hash(char[] password) {
        try
        {
            KeySpec spec = new PBEKeySpec(password, salt.getBytes(), iterations, derivedKeyLength);
            SecretKeyFactory f = SecretKeyFactory.getInstance(algorithm);
            StringBuffer hexString = new StringBuffer();
            byte[] mdbytes  =  f.generateSecret(spec).getEncoded();
            for (int i = 0 ; i < mdbytes.length ; i++)
            {
                hexString.append(Integer.toHexString(0xFF & mdbytes[i]));
            }
            String hashedPassword = hexString.toString();
            return hashedPassword;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException("Error computing hash: " + e.getMessage());
        }
    }
}
