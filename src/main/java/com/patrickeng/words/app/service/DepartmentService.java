package com.patrickeng.words.app.service;

import com.patrickeng.words.app.entity.Department;
import com.patrickeng.words.app.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public void save(Department department){
        departmentRepository.save(department);
    }

}
