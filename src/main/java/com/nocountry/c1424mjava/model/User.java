package com.nocountry.c1424mjava.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name", length = 20, nullable = false)
    private String name;

    // TODO: Manejar email invalido
    @Email
    @Column(name = "Email", length = 100, nullable = false, unique=true)
    private String email;

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "Password", nullable = false)
    private String password;

    /*
    @Column(name = "Role", nullable = false)
    private Role role;
     */

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
