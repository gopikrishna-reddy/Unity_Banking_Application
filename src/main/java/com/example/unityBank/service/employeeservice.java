package com.example.unityBank.service;

import com.example.unityBank.exception.AccountNotFoundException;
import com.example.unityBank.model.employee;
import com.example.unityBank.repo.employeerepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class employeeservice {
    @Autowired
    employeerepo repo;


    public employee addemployee(employee e) {
      return   repo.save(e);
    }

    public List<employee> getemployee() {
        return repo.findAll();
    }

    public employee getbiid(Integer id) {
        return repo.findById(id).get();
    }

    public String sendmonerbyservice(BigDecimal fromaccountnumber, BigDecimal toaccountnumber, BigDecimal amount) {
        employee fromacc=repo.findByAccountnumber(fromaccountnumber).orElseThrow(
                ()->new AccountNotFoundException("account not found mr gopi!!!")
        );
        employee toacc=repo.findByAccountnumber(toaccountnumber).orElseThrow(
                ()->new AccountNotFoundException("account not found")
        );
        if(fromacc.getEmpsalary().compareTo(amount)>=0){
            fromacc.setEmpsalary(
                    fromacc.getEmpsalary().subtract(amount)
            );
            repo.save(fromacc);

            toacc.setEmpsalary(
                    toacc.getEmpsalary().add(amount)
            );
            repo.save(toacc);
        }
        return "amount tranfered succseefully";




    }
}
