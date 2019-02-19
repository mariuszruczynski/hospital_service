package hospital_service.hospital_service.services;


import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class CustomUser extends User {

    private final Long idUser;


    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Long idUser) {
        super(username, password, authorities);
        this.idUser = idUser;
    }

    public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, Long idUser) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.idUser = idUser;
    }
}
