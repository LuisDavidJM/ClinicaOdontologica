package BackEndC2.ClinicaOdontologica.security;

import BackEndC2.ClinicaOdontologica.entity.Usuario;
import BackEndC2.ClinicaOdontologica.entity.UsuarioRole;
import BackEndC2.ClinicaOdontologica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatosIniciales implements ApplicationRunner {
@Autowired
private UsuarioRepository usuarioRepository;
@Autowired
private BCryptPasswordEncoder passwordEncoder;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Usuario ROLE_USER
        String userPassword = "user";
        String userPasswordEncoded = passwordEncoder.encode(userPassword);
        Usuario usuarioUser = new Usuario("Luis", UsuarioRole.ROLE_USER, userPasswordEncoded, "user@user.com", "Usuario User");

        // Usuario ROLE_ADMIN
        String adminPassword = "admin";
        String adminPasswordEncoded = passwordEncoder.encode(adminPassword);
        Usuario usuarioAdmin = new Usuario("David", UsuarioRole.ROLE_ADMIN, adminPasswordEncoded, "admin@admin.com", "Usuario Admin");

        usuarioRepository.save(usuarioUser);
        usuarioRepository.save(usuarioAdmin);

        System.out.println("User password cifrada: " + userPasswordEncoded);
        System.out.println("Admin password cifrada: " + adminPasswordEncoded);

    }
}
