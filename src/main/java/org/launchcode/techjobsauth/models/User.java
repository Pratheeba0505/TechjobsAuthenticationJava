package org.launchcode.techjobsauth.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User {
    @Id
    @NotNull
    private String username;
    @NotNull
    private String password;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {}


    public User(String username,String password) {
        this.username = username;
        this.password = encoder.encode(password);
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
    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, password);
    }

    public Object getId() {
        return null;
    }
}