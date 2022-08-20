package com.demo.repo;

import com.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query(value = "SELECT role_name, role_desc, ctime, mtime FROM role WHERE lower(role_name) LIKE lower(CONCAT('%', :role_name, '%')) and deleted = 0")
    public List<Role> search(@Param("role_name") String role_name);

}
