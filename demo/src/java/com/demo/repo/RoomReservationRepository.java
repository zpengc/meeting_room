package com.demo.repo;

import com.demo.model.RoomReservation;
import com.demo.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomReservationRepository extends JpaRepository<RoomReservation, Integer> {

    @Query("select p from room_reservation p where p.deleted = 0")
    public List<RoomReservation> list();

    @Query("select p from room_reservation p where p.username like :username and p.deleted = 0")
    public List<RoomReservation> search(String username);
}
