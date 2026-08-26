package com.example.unityBank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
//import org.springframework.data.annotation.Id;
import jakarta.persistence.Id;


@Entity
@Table(name="admins")
public class admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminid;
    private  String adminname;



    public admin(){

    }
    public admin(Integer adminid,String adminname){
        this.adminid=adminid;
        this.adminname=adminname;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }


}

