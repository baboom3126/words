package com.patrickeng.words.app.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Department")
public class Department {
    @Id
    @Column(name="DepartmentId")
    private int departmentId;

    @OneToMany(mappedBy="employeeId", cascade={CascadeType.PERSIST, CascadeType.MERGE}) // 串聯新增和更新
    private List<Employee> employeeList;
}
