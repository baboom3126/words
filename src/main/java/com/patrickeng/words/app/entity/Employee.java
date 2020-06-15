package com.patrickeng.words.app.entity;

import javax.persistence.*;

@Entity
@Table(name="Employee")
public class Employee {

    @Id
    @Column(name="EmployeeId")
    private int employeeId;

    @ManyToOne(fetch=FetchType.LAZY) // @ManyToOne JPA預設的fetch=FetchType.EAGER，改為FetchType.LAZY
    @JoinColumn(name="departmentId")
    private Department department;

    // getter and setter ommitted
}