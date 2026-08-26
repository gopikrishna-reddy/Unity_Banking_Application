package com.example.unityBank.model;

import jakarta.persistence.*;


import java.math.BigDecimal;
@Entity
@Table(name="unityemployee")
public class employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeid;
    private String empname;
    private BigDecimal empsalary;

    private BigDecimal accountnumber;


    public employee(){

    }

    public employee(Integer employeeid,String empname,BigDecimal empsalary,BigDecimal accountnumber) {
        this.employeeid = employeeid;
        this.empname=empname;
        this.empsalary=empsalary;
        this.accountnumber=accountnumber;

    }

    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public BigDecimal getEmpsalary() {
        return empsalary;
    }

    public void setEmpsalary(BigDecimal empsalary) {
        this.empsalary = empsalary;
    }

    public BigDecimal getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(BigDecimal accountnumber) {
        this.accountnumber = accountnumber;
    }


}
