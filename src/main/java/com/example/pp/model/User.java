package com.example.pp.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Component
@Table(name = "users")
public class User {

    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ToString.Include
    @Column(name = "username", length = 50)
    private String username;

    @ToString.Include
    @Column(name = "password", length = 50)
    private String password;
    @ToString.Include
    @Column(name = "roles", length = 50)

    @ManyToMany(fetch = FetchType.EAGER)
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

    public void setUsername(String username) {
        this.username = username;
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
