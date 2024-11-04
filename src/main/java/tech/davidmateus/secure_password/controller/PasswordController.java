package tech.davidmateus.secure_password.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.davidmateus.secure_password.model.UserPassword;
import tech.davidmateus.secure_password.service.PasswordService;

@RestController
public class PasswordController {
    @Autowired
    private PasswordService passwordService;
    @PostMapping("/validate-password")
    public ResponseEntity<String> validateAndSavePassword(@RequestBody UserPassword userPassword){
        if(passwordService.isValidPassword(userPassword.getPassword())){
            passwordService.savePassword(userPassword);
            return ResponseEntity.ok("Senha valida e salva com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Senha inválida. A senha deve conter pelo menos 8 caracteres, incluindo letras maiúsculas, minúsculas, números e caracteres especiais.");
        }
    }
}
