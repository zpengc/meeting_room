package com.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "room_info")
public class RoomInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;  // 几楼位置

    private int capacity;

    private int has_projector;

    private int has_laptop;

    private int deleted;



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

//    public Date getCtime() {
//        return ctime;
//    }
//
//    public Date getMtime() {
//        return mtime;
//    }

    public RoomInfo(String name, String description, int capacity, int has_projector, int has_laptop, int deleted) {
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.has_projector = has_projector;
        this.has_laptop = has_laptop;
        this.deleted = deleted;
    }

    public RoomInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getHas_projector() {
        return has_projector;
    }

    public void setHas_projector(int has_projector) {
        this.has_projector = has_projector;
    }

    public int getHas_laptop() {
        return has_laptop;
    }

    public void setHas_laptop(int has_laptop) {
        this.has_laptop = has_laptop;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}
