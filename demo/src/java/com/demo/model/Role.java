package com.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String role_name;

    private String role_desc;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date ctime;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date mtime;

    private int deleted;

    public Role(String role_name, String role_desc, int deleted) {
        this.role_name = role_name;
        this.role_desc = role_desc;
        this.deleted = deleted;
    }

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_desc() {
        return role_desc;
    }

    public void setRole_desc(String role_desc) {
        this.role_desc = role_desc;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int status) {
        this.deleted = status;
    }
}
