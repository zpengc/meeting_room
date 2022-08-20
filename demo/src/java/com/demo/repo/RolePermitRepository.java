package com.demo.repo;

import com.demo.model.RolePermit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermitRepository extends JpaRepository<RolePermit, Integer> {

}
