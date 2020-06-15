package com.patrickeng.words.app.entity;

import javax.persistence.*;

@Entity
@Table(name="Employee")
public class Employee {

    @Id
    @Column(name="EmployeeId")
    private int employeeId;

    @Column(name="EmployeeName")
    private String employeeName;

    @ManyToOne(fetch=FetchType.LAZY) // @ManyToOne JPA預設的fetch=FetchType.EAGER，改為FetchType.LAZY
    @JoinColumn(name="departmentId")
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