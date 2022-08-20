package com.demo.service;

import com.demo.model.RoomInfo;
import com.demo.model.RoomReservation;
import com.demo.repo.RoomReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReservationService {

    @Autowired
    RoomReservationRepository repo;

    public List<RoomReservation> list() {
        return repo.list();
    }

    public void save(RoomReservation reservation) {
        repo.save(reservation);
    }

    public void delete(int id) {
        RoomReservation reservation = repo.getOne(id);
        if (reservation.getId() == 0) {
            return;
        }
        reservation.setDeleted(1);
        repo.save(reservation);
    }

    public List<RoomReservation> search(String username) {
        return repo.search(username);
    }
    public RoomReservation get(int id) {
        return repo.findById(id).get();
    }

}
