package com.patrickeng.words.app.repository;

import com.patrickeng.words.app.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends JpaRepository<Department,String>, CrudRepository<Department,String> {
}
