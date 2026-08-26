package com.example.unityBank.repo;

import com.example.unityBank.model.custmor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public  interface custmorrepo extends JpaRepository <custmor,Integer>{

    Optional<custmor> findByAccountnumber(BigDecimal accountnumber);



    Optional<custmor> deleteByAccountnumber(BigDecimal accountnumber);

}