package com.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "role_permit")
public class RolePermit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int role_id;

    private String permit;

    private int deleted;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date ctime;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date mtime;

    public RolePermit(int role_id, String permit, int deleted) {
        this.role_id = role_id;
        this.permit = permit;
        this.deleted = deleted;
    }

    public RolePermit() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getPermit() {
        return permit;
    }

    public void setPermit(String permit) {
        this.permit = permit;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}
