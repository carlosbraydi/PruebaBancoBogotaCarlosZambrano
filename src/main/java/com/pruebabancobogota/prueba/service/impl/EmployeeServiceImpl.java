package com.pruebabancobogota.prueba.service.impl;

import com.pruebabancobogota.prueba.model.Employee;
import com.pruebabancobogota.prueba.repository.IEmployeeRepository;
import com.pruebabancobogota.prueba.service.IEmployeeService;
import com.pruebabancobogota.prueba.vo.EmployeeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository repository;

    @Override
    public List<Employee> getEmployees() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(employee -> {
                    employee.setEmployees(listEmployess(employee));
                    return employee;
                }).collect(Collectors.toList());
    }

    @Override
    public Employee getEmployee(Integer idEmployee) {
        return repository.findById(idEmployee).map(employee -> {
            employee.setEmployees(listEmployess(employee));
            return employee;
        }).orElse(null);
    }

    @Override
    public Employee postEmployee(EmployeeVo employee) {
        Employee mEmployee = new Employee();
        mEmployee.setIdEmployee(employee.getIdEmployee());
        mEmployee.setFullName(employee.getFullName());
        mEmployee.setFunction(employee.getFunction());

        if (!Objects.isNull(employee.getBoss())) {
            Employee eBoss = new Employee();
            eBoss.setIdEmployee(employee.getBoss());
            mEmployee.setBoss(eBoss);
        }

        if (!Objects.isNull(employee.getEmployees())) {
            List<Employee> employees = employee.getEmployees().stream().map(employeeId -> {
                        Employee employeeAdd = new Employee();
                        employeeAdd.setIdEmployee(employeeId);
                        return employeeAdd;
                    }).collect(Collectors.toList());
            mEmployee.setEmployees(employees);
        }

        return repository.save(mEmployee);
    }

    private List<Employee> listEmployess(Employee employee) {
        if (Objects.isNull(employee.getEmployees())) {
            employee.setEmployees(new ArrayList<>());
        }
        employee.getEmployees().addAll(repository.getEmployeeById(employee.getIdEmployee()));
        return employee.getEmployees();
    }

    @Override
    public boolean deleteEmployee(Integer idEmployee) {
        try {
            repository.deleteById(idEmployee);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
