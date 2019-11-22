package com.example.restservice.h2.embedded.db.rest.crud.model;


import com.example.restservice.h2.embedded.db.rest.crud.utils.Utils;
import com.example.restservice.h2.embedded.db.rest.crud.validator.UserNameValidation;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long Id;

    @UserNameValidation
    @NotNull(message = Utils.USERNAME_REQUIRED_EXCEPTION)
    private String username;

    @Email(message = Utils.EMAIL_NOT_VALID_EXCEPTION)
    private String email;

    @NotNull(message = Utils.PASSWORD_REQUIRED_EXCEPTION)
    @Pattern(regexp = Utils.PASSWORD_VALIDATION_REGEX, message = Utils.PASSWORD_NOT_VALID_EXCEPTION)
    private String password;

    private String name;

    private String lastname;

    public User(String username, String email, String password, String name, String lastname) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
    }

    public User() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "User [Id=" + Id + ", username=" + username + ", email=" + email + ", password=" + password + ", name=" + name + ", lastname=" + lastname + "]";
    }

}
