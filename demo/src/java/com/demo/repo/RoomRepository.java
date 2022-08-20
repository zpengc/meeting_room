package com.demo.repo;

import com.demo.model.Role;
import com.demo.model.RoomInfo;
import com.demo.model.RoomSearchRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<RoomInfo, Integer> {

    @Query("SELECT p FROM room_info p WHERE (:name is null or p.name like :name) " +
            "and (:desc is null or p.description like :desc) and (:capacity is null or p.capacity = :capacity) and p.deleted = 0")
    public List<RoomInfo> search(@Param("name") String name, @Param("desc") String desc,
                                 @Param("capacity") int capacity);

    @Query("select p from room_info p where p.deleted = 0")
    public List<RoomInfo> list();

}
