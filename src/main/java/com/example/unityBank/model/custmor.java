package com.example.unityBank.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


import java.math.BigDecimal;
import java.util.Date;
@Entity
@Table(name="custmors")
public class custmor {
    @Column(name="frist_name" ,nullable = false,length = 100)
    private String accountholderfristname;

    @Column(name="last_name" ,nullable = false,length = 100)
    private String accountholderlastname;
    @NotNull
    private String dateofbirth;
    @Id
    private BigDecimal accountnumber;

    private String accountname;
    private String email;
    private  String address;
    private BigDecimal mobilenumber;
    @NotBlank
    private String pannumber;
    private  String accontstatus;
    @Positive

    private BigDecimal accountmoney;

    public custmor(){}

    public custmor(String accountholderfristname,String accountholderlastname,String dateofbirth,BigDecimal accountnumber,String accountname,String email,String address,
                   BigDecimal mobilenumber,String pannumber,String accontstatus,BigDecimal accountmoney){
        this.accountholderfristname=accountholderfristname;
        this.accountholderlastname=accountholderlastname;
        this.dateofbirth=dateofbirth;
        this.accountnumber=accountnumber;
        this.accountname=accountname;
        this.email=email;
        this.address=address;
        this.mobilenumber=mobilenumber;
        this.pannumber=pannumber;
        this.accontstatus=accontstatus;
        this.accountmoney=accountmoney;
    }

    public String getAccountholderfristname() {
        return accountholderfristname;
    }

    public void setAccountholderfristname(String accountholderfristname) {
        this.accountholderfristname = accountholderfristname;
    }

    public String getAccountholderlastname() {
        return accountholderlastname;
    }

    public void setAccountholderlastname(String accountholderlastname) {
        this.accountholderlastname = accountholderlastname;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }


    public BigDecimal getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(BigDecimal accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(BigDecimal mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getPannumber() {
        return pannumber;
    }

    public void setPannumber(String pannumber) {
        this.pannumber = pannumber;
    }

    public String getAccontstatus() {
        return accontstatus;
    }

    public void setAccontstatus(String accontstatus) {
        this.accontstatus = accontstatus;
    }

    public BigDecimal getAccountmoney() {
        return accountmoney;
    }

    public void setAccountmoney(BigDecimal accountmoney) {
        this.accountmoney = accountmoney;
    }
}
