package fr.humanbooster.vignerontristan.security;
import fr.humanbooster.vignerontristan.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private JwtTokenFilter jwtTokenFilter;
    private PasswordEncoder passwordEncoder;
    private     UserService userService;

    @Bean
    public SecurityFilterChain getFilterChain(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers("/api/login", "/api/register").permitAll()
                                .requestMatchers(
                                        AntPathRequestMatcher.antMatcher("/v3/api-docs/**"),
                                        AntPathRequestMatcher.antMatcher("/swagger-ui/**")
                                ).permitAll()
                                .requestMatchers(
                                        AntPathRequestMatcher.antMatcher("/api/user/me"),
                                        AntPathRequestMatcher.antMatcher("/api/user/upload"),
                                        AntPathRequestMatcher.antMatcher("/api/user"),
                                        AntPathRequestMatcher.antMatcher("/api/game/**"),
                                        AntPathRequestMatcher.antMatcher("/api/game"),

                                        AntPathRequestMatcher.antMatcher("/api/rounds"),
                                        AntPathRequestMatcher.antMatcher("/api/coordinates")
                                ).authenticated()                                .requestMatchers(
                                        AntPathRequestMatcher.antMatcher("/api/maps/**"),
                                        AntPathRequestMatcher.antMatcher( "/api/maps")
                                ).hasRole("ADMIN")

                );
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
