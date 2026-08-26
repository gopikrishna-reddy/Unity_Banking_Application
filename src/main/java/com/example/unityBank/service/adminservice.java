package com.example.unityBank.service;

import com.example.unityBank.model.admin;
import com.example.unityBank.repo.adminrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class adminservice {
    @Autowired
    adminrepo repo;

    public void adddata(admin a) {
        repo.save(a);
    }

    public List<admin> getdata() {
        return repo.findAll();
    }
}
