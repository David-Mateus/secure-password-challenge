package tech.davidmateus.secure_password;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.davidmateus.secure_password.model.UserPassword;

@Repository
public interface PasswordRepository extends JpaRepository<UserPassword, Long> {
}
