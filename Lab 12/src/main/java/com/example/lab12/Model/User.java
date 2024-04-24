package com.example.lab12.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Getter
@Setter
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotEmpty(message = "username cannot be empty")
    @Column(columnDefinition = "varchar(10) unique")
    private String username;

    @NotEmpty(message = "password cannot be empty")
    @Column(columnDefinition = "varchar(60)")
    private String password;

    @Pattern(regexp = "^(ADMIN|CUSTOMER)")
    @Column(columnDefinition = "varchar(8)")
    private String role;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Blog> blogs;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.role));
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
