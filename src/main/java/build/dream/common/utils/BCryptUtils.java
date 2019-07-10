package build.dream.common.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

import java.security.SecureRandom;

public class BCryptUtils {
    public static String encode(CharSequence rawPassword, int strength, SecureRandom secureRandom) {
        String salt;
        if (strength > 0) {
            if (secureRandom != null) {
                salt = BCrypt.gensalt(strength, secureRandom);
            } else {
                salt = BCrypt.gensalt(strength);
            }
        } else {
            salt = BCrypt.gensalt();
        }
        return BCrypt.hashpw(rawPassword.toString(), salt);
    }

    public static String encode(CharSequence rawPassword, int strength) {
        return encode(rawPassword, strength, null);
    }

    public static String encode(CharSequence rawPassword) {
        return encode(rawPassword, -1);
    }
}
