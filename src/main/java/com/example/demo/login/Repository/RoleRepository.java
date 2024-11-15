package com.example.demo.login.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.login.Entity.RoleEntity;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long>{
    List<RoleEntity> findRoleEntitiesByRoleEnumIn(List<String> roleNames);
}
