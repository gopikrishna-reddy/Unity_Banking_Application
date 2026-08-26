package com.example.unityBank.controller;

import com.example.unityBank.model.employee;
import com.example.unityBank.service.employeeservice;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@Transactional
@RequestMapping("/employee")

public class employeecontroller {

    @Autowired
    employeeservice service;



    @PostMapping("/add")

    public employee addemployeedata(@RequestBody employee e){
        return service.addemployee(e);
    }

    @GetMapping("/all")
    public List<employee> getallemployee(){
        return service.getemployee();
    }

    @GetMapping("/{id}")
    public employee getbyidemp(@PathVariable Integer id){
        return service.getbiid(id);
    }
    @PostMapping("/send")
    public String sendmonrey(@RequestParam BigDecimal fromaccountnumber,@RequestParam BigDecimal toaccountnumber,@RequestParam BigDecimal amount){
        service.sendmonerbyservice(fromaccountnumber,toaccountnumber,amount);
        return "money transfered";
    }










}
