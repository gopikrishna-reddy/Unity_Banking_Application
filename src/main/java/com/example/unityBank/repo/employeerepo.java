package com.example.unityBank.repo;

import com.example.unityBank.model.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository

public  interface employeerepo extends JpaRepository<employee,Integer> {

    Optional<employee> findByAccountnumber(BigDecimal accountnumber);
}

