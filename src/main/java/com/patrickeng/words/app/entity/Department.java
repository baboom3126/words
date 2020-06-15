package com.patrickeng.words.app.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Department")
public class Department {
    @Id
    @Column(name="DepartmentId")
    private int departmentId;

    @Column(name="DepartmentName")
    private String departmentName;

    @OneToMany(mappedBy="department", cascade={CascadeType.PERSIST, CascadeType.MERGE}) // 串聯新增和更新
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
