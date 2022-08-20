package com.demo.service;

import com.demo.model.UserInfo;
import com.demo.model.UserStatus;
import com.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository repo;

    public long save(UserInfo userInfo) {
        return repo.save(userInfo).getId();  // 返回插入db的主键
    }

    public void delete(long id) {  // soft delete
        UserInfo userInfo = repo.getOne(id);
        if (userInfo.getId() == 0) {
            return;
        }
        userInfo.setStatus(UserStatus.Deleted.ordinal());  // 2-离职
        repo.save(userInfo);
    }

    public void frozen(long id) {  // soft delete
        UserInfo userInfo = repo.getOne(id);
        if (userInfo.getId() == 0) {
            return;
        }
        userInfo.setStatus(UserStatus.Frozen.ordinal());  // 1-冻结
        repo.save(userInfo);
    }

    public void update(UserInfo userInfo) {
        repo.save(userInfo);
    }

    public List<UserInfo> search(String username) {
        return repo.search(username);
    }

    public UserInfo get(long id) {
        return repo.findById(id).get();
    }

    public List<UserInfo> list() {
        return repo.list();
    }

}
