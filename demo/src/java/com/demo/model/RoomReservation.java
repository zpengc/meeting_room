package com.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "room_reservation")
public class RoomReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int room_id;

    private String username;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date stime;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date etime;

    private int deleted;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date ctime;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date mtime;

    public RoomReservation(int room_id, String username, Date stime, Date etime) {
        this.room_id = room_id;
        this.username = username;
        this.stime = stime;
        this.etime = etime;
    }

    public RoomReservation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getStime() {
        return stime;
    }

    public void setStime(Date stime) {
        this.stime = stime;
    }

    public Date getEtime() {
        return etime;
    }

    public void setEtime(Date etime) {
        this.etime = etime;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}
