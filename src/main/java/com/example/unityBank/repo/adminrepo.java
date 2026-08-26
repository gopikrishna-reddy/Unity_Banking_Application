package com.example.unityBank.repo;

import com.example.unityBank.model.admin;
import com.example.unityBank.model.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface adminrepo extends JpaRepository<admin,Integer> {


}
