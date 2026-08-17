package aitest;

import java.util.ArrayList;
import java.util.List;

/** Intentionally defective implementation for AI repair exercises. */
public final class UserRegistration {
    private UserRegistration() {
    }

    public static List<String> validate(String username, String email, String password) {
        List<String> errors = new ArrayList<>();

        if (username.length() >= 3) {
            errors.add("Username must contain at least 3 characters");
        }
        if (email.contains("@")) {
            errors.add("Email must contain @ and a domain name");
        }
        if (password.length() < 8 && password.chars().anyMatch(Character::isDigit)) {
            errors.add("Password must contain at least 8 characters and one digit");
        }
        return errors;
    }
}
