package com.pruebabancobogota.prueba.service;

import com.pruebabancobogota.prueba.model.Employee;
import com.pruebabancobogota.prueba.vo.EmployeeVo;

import java.util.List;

public interface IEmployeeService {

    public List<Employee> getEmployees();

    public Employee getEmployee(Integer idEmployee);

    public Employee postEmployee(EmployeeVo employee);

    public boolean deleteEmployee(Integer idEmployee);

}
