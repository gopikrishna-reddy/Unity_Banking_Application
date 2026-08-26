package com.example.unityBank.service;

import com.example.unityBank.exception.AccountNotFoundException;
import com.example.unityBank.model.custmor;
import com.example.unityBank.repo.custmorrepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional

public class custmorservice {
    @Autowired
    custmorrepo crepo;


    public void postcustmordataservice(custmor c) {
        crepo.save(c);
    }

    public String sendMoney(BigDecimal fromAccountNumber, BigDecimal toAccountNumber, BigDecimal Amount){

        custmor fromAcc = crepo.findByAccountnumber(fromAccountNumber).get();
        custmor toAcc = crepo.findByAccountnumber(toAccountNumber).get();
        if(fromAcc.getAccontstatus().equals("ACTIVE") &&
                toAcc.getAccontstatus().equals("ACTIVE")){
            if(fromAcc.getAccountmoney().compareTo(Amount) >= 0){
                fromAcc.setAccountmoney(
                        fromAcc.getAccountmoney().subtract(Amount)
                );
                crepo.save(fromAcc);
                toAcc.setAccountmoney(
                        toAcc.getAccountmoney().add(Amount)
                );
                crepo.save(toAcc);

            }
        }
        return "Money sent successfully";

    }

    public List<custmor> allholders() {
        return crepo.findAll();
    }

    public custmor getoneaccountholder(BigDecimal accountnumber) {
       return crepo.findByAccountnumber(accountnumber).get();
    }


    public void delete(BigDecimal accountnumber) {
        crepo.deleteByAccountnumber(accountnumber);
    }

    public String sendservice(BigDecimal accountnumber, BigDecimal amount) {
        custmor acc=crepo.findByAccountnumber(accountnumber).get();
      if(acc.getAccontstatus().equals("ACTIVE")){
          acc.setAccountmoney(
                  acc.getAccountmoney().add(amount)
          );
          crepo.save(acc);
      }
      return "money credited successfully";

    }

    public void debitmoneeyholder(BigDecimal accountnumber, BigDecimal amount) {
        custmor acount=crepo.findByAccountnumber(accountnumber).orElseThrow(
                ()->new RuntimeException("account not found"));
        if(acount.getAccontstatus().equals("ACTIVE")){
            acount.setAccountmoney(
            acount.getAccountmoney().subtract(amount));
            crepo.save(acount);

        }
       ;
    }

    public String loanservice(BigDecimal accountnumber) {
        custmor accountloan=crepo.findByAccountnumber(accountnumber).orElseThrow(
                (() -> new AccountNotFoundException("Account not found"))
        );
        if("ACTIVE".equals(accountloan.getAccontstatus()) && "East Gangavaram".equalsIgnoreCase(accountloan.getAddress())){

            return "Congratulations! Your loan has been approved.";
        }



        return "Sorry, your loan application has been rejected.";








    }

//    public void daletedata(BigDecimal accountnumber) {
//        crepo.updateByAccountnumber(accountnumber);
//    }
}
