package com.example.pp.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;
@Data
@Entity
@Component
@Table(name = "person")
public class Person {

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
    public Person(){

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

    public Person(long id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }
}
