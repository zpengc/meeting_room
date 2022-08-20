package com.demo.repo;

import com.demo.model.RoomReservation;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ReservationRepositoryTest {

    private RoomReservationRepository repo;

    @Test
    public void save() {
        System.out.println(new Date());
        RoomReservation reservation = new RoomReservation(111, "zpc", new Date(), new Date());
        RoomReservation save = repo.save(reservation);
        System.out.println(save);
    }
}
