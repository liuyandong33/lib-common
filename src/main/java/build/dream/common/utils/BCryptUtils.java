package build.dream.common.utils;

import build.dream.common.crypto.BCrypt;

import java.security.SecureRandom;
import java.util.Objects;

public class BCryptUtils {
    public static String encode(CharSequence rawPassword, int strength, SecureRandom secureRandom) {
        if (strength <= 0) {
            return BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt());
        }

        if (Objects.isNull(secureRandom)) {
            return BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt(strength));
        }

        return BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt(strength, secureRandom));
    }

    public static String encode(CharSequence rawPassword, int strength) {
        return encode(rawPassword, strength, null);
    }

    public static String encode(CharSequence rawPassword) {
        return encode(rawPassword, -1);
    }
}
