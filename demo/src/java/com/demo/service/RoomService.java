package com.demo.service;


import com.demo.model.RoomInfo;
import com.demo.model.RoomSearchRequest;
import com.demo.repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomService {

    @Autowired
    RoomRepository repo;

    public List<RoomInfo> list() {
        return repo.list();
    }

    public void add(RoomInfo roomInfo) {
        repo.save(roomInfo);
    }

    public RoomInfo get(int id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        RoomInfo roomInfo = repo.getOne(id);
        if (roomInfo.getId() == 0){
            return;
        }
        roomInfo.setDeleted(1);
        repo.save(roomInfo);
    }

    public void update(RoomInfo roomInfo) {
       repo.save(roomInfo);
    }

    public List<RoomInfo> search(RoomInfo request) {
        return repo.search(request.getName(), request.getDescription(), request.getCapacity());
    }
}
