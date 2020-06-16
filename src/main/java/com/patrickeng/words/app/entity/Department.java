package com.patrickeng.words.app.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Department")
public class Department implements Serializable {
    @Id
    @Column(name="DepartmentId")
    private int departmentId;

    @Column(name="DepartmentName")
    private String departmentName;

    @OneToMany(mappedBy="department", cascade={CascadeType.ALL}) // 串聯新增和更新
    @JsonManagedReference
    private List<Employee> employeeList;

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
