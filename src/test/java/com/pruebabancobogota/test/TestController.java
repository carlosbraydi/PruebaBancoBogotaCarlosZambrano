package com.pruebabancobogota.test;

import com.pruebabancobogota.prueba.controller.EmployeeController;
import com.pruebabancobogota.prueba.model.Employee;
import com.pruebabancobogota.prueba.service.IEmployeeService;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestController {
    @InjectMocks
    private EmployeeController controller;

    @Mock
    private IEmployeeService service;

    @Test
    public void given_whenGetEmployees_thenReturnEMployees() {
        List<Employee> employess = new ArrayList<>();
        employess.add(new Employee(1, "carlos zambrano", "Developer"));
        when(service.getEmployees()).thenReturn(employess);
        List<Employee> list = controller.getEmployees();
        Assert.assertEquals(list.size(), employess.size());

    }
}
