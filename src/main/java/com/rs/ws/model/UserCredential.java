package com.rs.ws.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_credential")
public class UserCredential implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "seq_id_creden")
    private Long id;
    @JoinColumn(name = "user_name")
    private String userName;
    @JoinColumn(name = "password")
    private String password;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_type")
    private UserType userType;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<UserType> userTypes= new ArrayList<>();
        userTypes.add(userType);
        return userTypes;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
