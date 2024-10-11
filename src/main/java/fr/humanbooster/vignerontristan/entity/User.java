package fr.humanbooster.vignerontristan.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.vignerontristan.jsonviews.GameJsonview;
import fr.humanbooster.vignerontristan.jsonviews.RoundJsonview;
import fr.humanbooster.vignerontristan.jsonviews.UserJsonview;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonView({GameJsonview.GameListView.class, UserJsonview.UserShowView.class})
    private String id;

    @NotBlank
    @JsonView({GameJsonview.GameListView.class, UserJsonview.UserShowView.class})
    private String username;

    @NotBlank
    @JsonView( UserJsonview.UserShowView.class)
    private String email;

    @NotBlank
    private String password;

    @JsonView( UserJsonview.UserShowView.class)
    private String avatar;

    @NotNull
    @Past
    @JsonView( UserJsonview.UserShowView.class)
    private LocalDate birthedAt;

    @NotNull
    @JsonView( UserJsonview.UserShowView.class)
    private LocalDateTime createdAt;

    @NotNull
    @JsonView({GameJsonview.GameListView.class, UserJsonview.UserShowView.class})
    private Integer level = 1;

    @NotBlank
    private String roles = "ROLE_USER";

    @OneToMany(mappedBy = "user")
    private List<Game> game = new ArrayList<>();

    @JsonView( UserJsonview.UserShowView.class)
    private Boolean getIsAdmin() {
        return roles.contains("ROLE_ADMIN");
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        if(roles.contains("ADMIN")) {
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
        }
        return authorities;
    }
}