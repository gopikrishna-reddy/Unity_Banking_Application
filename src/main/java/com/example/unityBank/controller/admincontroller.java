package com.example.unityBank.controller;

import com.example.unityBank.model.admin;
import com.example.unityBank.service.adminservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class admincontroller {
    @Autowired
    adminservice service;

    @PostMapping("/add")
    public String addadmin(@RequestBody admin a){
        service.adddata(a);
        return "add the data sussfully";

    }
    @GetMapping("/all")
    public List<admin> getalldata(){
        return service.getdata();
    }

}
