package com.lucky.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * Created by lucky on 16-12-27.
 */
public class User implements Serializable {
    @Transient
    private static final long seiralVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "JDBC")
    private long userId;
    private String username;
    @JsonIgnore
    private String password;
    private String email;

    @Transient
    private Role role;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
