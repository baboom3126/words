package com.patrickeng.words.app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Employee")
public class Employee implements Serializable {

    @Id
    @Column(name="EmployeeId")
    private int employeeId;

    @Column(name="EmployeeName")
    private String employeeName;

    @ManyToOne(fetch=FetchType.LAZY) // @ManyToOne JPA預設的fetch=FetchType.EAGER，改為FetchType.LAZY
    @JoinColumn(name="DepartmentId")
    @JsonBackReference
    private Department department;

    // getter and setter ommitted

    public String getEmployeeName() {
        return employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}