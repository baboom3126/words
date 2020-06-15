package com.patrickeng.words.app.repository;

import com.patrickeng.words.app.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends JpaRepository<Employee,String>, CrudRepository<Employee,String> {
}
