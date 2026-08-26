package com.example.unityBank.controller;

import com.example.unityBank.model.custmor;
import com.example.unityBank.service.custmorservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/custmor")
public class custmorcontroller {

    @Autowired
    custmorservice service;

    @PostMapping("/add")
    public String postcustmordata(@RequestBody custmor c){
        service.postcustmordataservice(c);
        return "added the data succssfully";
    }

    @PostMapping("/sendMoney")
    public String postcustmordata(@RequestParam BigDecimal fromAccountNumber,@RequestParam BigDecimal toAccountNumber,@RequestParam BigDecimal Amount){
        String s = service.sendMoney(fromAccountNumber,toAccountNumber,Amount);
        return s;
    }

    @GetMapping("/all")
    public List<custmor> getallcustmordetails(){
        return service.allholders();
    }
    @GetMapping("/{accountnumber}")

    public custmor getbyacccountnumber(@PathVariable BigDecimal accountnumber){
       return service.getoneaccountholder(accountnumber);

    }

  @DeleteMapping("/{accountnumber}")
    public String deletebyid(@PathVariable BigDecimal accountnumber){
        service.delete(accountnumber);
        return "deleted data successfully";
  }
//  @PutMapping("/account/{accountnumber}")
//    public String updateaccountholder(@PathVariable BigDecimal accountnumber){
//        service.daletedata(accountnumber);
//        return "deleted data successfully";
//  }

    @PostMapping("/credit")

    public String sendmoney(@RequestParam BigDecimal accountnumber,@RequestParam BigDecimal amount){
        String g=service.sendservice(accountnumber,amount);
        return g;
    }

    @PostMapping("/debit")
    public String debitmoney(@RequestParam BigDecimal accountnumber,@RequestParam BigDecimal amount){
        service.debitmoneeyholder(accountnumber,amount);
        return "amount amount debited";
    }

    @GetMapping("/loan/{accountnumber}")
    public String loanholder(@PathVariable BigDecimal accountnumber){
       String d= service.loanservice(accountnumber);
       return d;

    }





}
