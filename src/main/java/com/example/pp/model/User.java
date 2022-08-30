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
    @Column(name = "name", length = 50)
    private String name;

    @ToString.Include
    @Column(name = "lastname", length = 50)
    private String lastname;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
    public User(long id, String name, String lastname, String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
    }
}
