package com.demo.model;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "user_info")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private int status;

//    @Temporal(value = TemporalType.TIMESTAMP)
//    private Date ctime;
//
//    @Temporal(value = TemporalType.TIMESTAMP)
//    private Date mtime;
//
//    @PrePersist
//    void createdAt() {
//        this.ctime = this.mtime = new Date();
//    }
//
//    @PreUpdate
//    void updatedAt() {
//        this.mtime = new Date();
//    }


    public UserInfo() {
    }

    public UserInfo(String username, String password, int status) {
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
