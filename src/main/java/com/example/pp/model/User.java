package com.example.pp.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Data
@Entity
@Component
@Table(name = "users")
public class User implements UserDetails {

    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ToString.Include
    @Column(name = "username", length = 50)
    private String username;

    @ToString.Include
    @Column(name = "password", length = 100)
    private String password;
    @ToString.Include
    @Column(name = "roles", length = 50)

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Role> roles;
    @Transient
    private String passwordConfirm;
    public User(){

    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
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

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
    public User(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
