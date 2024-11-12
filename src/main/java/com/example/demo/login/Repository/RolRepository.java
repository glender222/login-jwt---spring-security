package com.example.demo.login.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.login.Entity.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{

}
