package com.demo.repo;

import com.demo.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {


    @Query("select p from user_info p where p.username like :username and p.status = 0")
    public List<UserInfo> search(@Param("username") String username);

    @Query("select p from user_info p where p.status = 0")
    public List<UserInfo> list();
}
