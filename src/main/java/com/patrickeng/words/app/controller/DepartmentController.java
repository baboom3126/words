package com.patrickeng.words.app.controller;


import com.patrickeng.words.app.entity.Department;
import com.patrickeng.words.app.entity.Employee;
import com.patrickeng.words.app.service.DepartmentService;
import com.patrickeng.words.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/query/{para}")
    @ResponseBody
    public ResponseEntity<?> test1(HttpServletRequest request, HttpServletResponse response, @PathVariable final String para) {


        Department department = new Department();
        List<Department> departmentList = departmentService.findAll();


        return new ResponseEntity<List<Department>>(departmentList, HttpStatus.OK);


    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/test/{para}")
    @ResponseBody
    public ResponseEntity<?> test2(HttpServletRequest request, HttpServletResponse response, @PathVariable final String para) {

        Department department = new Department();
        department.setDepartmentId(2);
        department.setDepartmentName("test_dep");

        Employee employee1 = new Employee();
        employee1.setEmployeeId(1003);
        employee1.setEmployeeName("test1");
        employee1.setDepartment(department);


        Employee emploee2 = new Employee();
        emploee2.setEmployeeId(1004);
        emploee2.setEmployeeName("test2");
        emploee2.setDepartment(department);

        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(employee1);
        employeeList.add(emploee2);
        department.setEmployeeList(employeeList);
        departmentService.save(department);
        return new ResponseEntity<Department>(department, HttpStatus.OK);

    }
}
