package com.netflixclone.entities;

import java.util.Objects;

public class User {

    private Integer sessionId;
    private String name;
    private Integer age;
    private String email;
    private String password;

    public User(Integer sessionId, String name, Integer age, String email, String password) {
        this.sessionId = sessionId;
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public Integer getSessionId() {
        return sessionId;
    }
    
    public void setSessionId(Integer id) {
        this.sessionId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
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

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof User)) return false;
        if (!super.equals(object)) return false;
        User user = (User) object;
        return Objects.equals(sessionId, user.sessionId) && Objects.equals(email, user.email);
    }


}