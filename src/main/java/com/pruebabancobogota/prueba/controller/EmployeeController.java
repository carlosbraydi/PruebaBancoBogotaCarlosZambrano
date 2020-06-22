package com.pruebabancobogota.prueba.controller;

import com.pruebabancobogota.prueba.model.Employee;
import com.pruebabancobogota.prueba.service.IEmployeeService;
import com.pruebabancobogota.prueba.vo.EmployeeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {

    @Autowired
    private IEmployeeService service;

    @GetMapping(value = "")
    public List<Employee> getEmployees() {
        return service.getEmployees();
    }

    @GetMapping(value = "/info")
    public Employee getEmployee(@RequestParam("idEmployee") Integer idEmployee) {
        return service.getEmployee(idEmployee);
    }

    @PostMapping(value = "")
    public Employee postEmployee(@RequestBody EmployeeVo employee) {
        return service.postEmployee(employee);
    }

    @DeleteMapping(value = "/delete")
    public boolean deleteEmployee(@RequestParam("idEmployee") Integer idEmployee) {
        return service.deleteEmployee(idEmployee);
    }

    @PostMapping(value = "/update")
    public Employee updateEmployee(@RequestBody EmployeeVo employee) {
        return service.postEmployee(employee);
    }
}
