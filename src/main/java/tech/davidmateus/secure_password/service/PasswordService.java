package tech.davidmateus.secure_password.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.davidmateus.secure_password.PasswordRepository;
import tech.davidmateus.secure_password.model.UserPassword;

@Service
public class PasswordService {
    @Autowired
    private PasswordRepository password;

    public boolean isValidPassword(String password){
        if(password == null || password.isEmpty()){
            return false;
        }
        boolean hasUppercase = password.chars().anyMatch(Character::isUpperCase);
        boolean hasLowercase = password.chars().anyMatch(Character::isLowerCase);
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);
        boolean hasSpecialChar = password.chars().anyMatch(ch -> "!@#$%^&*()".indexOf(ch) >= 0);
        boolean hasMinLength = password.length() >= 8;

        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar && hasMinLength;
    }
    public UserPassword savePassword(UserPassword userPassword) {
        return password.save(userPassword);
    }
}
