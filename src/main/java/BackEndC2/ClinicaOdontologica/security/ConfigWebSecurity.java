package BackEndC2.ClinicaOdontologica.security;

import BackEndC2.ClinicaOdontologica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import static org.springframework.security.authorization.AuthorityReactiveAuthorizationManager.hasRole;
import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
public class ConfigWebSecurity {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Bean //este metodo va a proveernos de la autenticacion de la aplicacion
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(usuarioService);
        return provider;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(AbstractHttpConfigurer::disable)
                //Para hacer pruebas de integracion
                /*.authorizeHttpRequests(authz -> authz
                        .anyRequest().permitAll()
                );*/
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/login", "/logout", "/css/**").permitAll()
                        .requestMatchers("/", "/index.html").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/js/**","/post_turno.html", "/get_turno.html").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login.html")  // Página de login personalizada
                        .loginProcessingUrl("/login")  // URL para procesar el formulario de login
                        .defaultSuccessUrl("/", true)  // URL a la que se redirige después del login exitoso
                        .failureUrl("/login.html?error=true")  // URL a la que se redirige en caso de fallo
                        .permitAll()
                )
                .logout(withDefaults());
        return http.build();
    }

}
