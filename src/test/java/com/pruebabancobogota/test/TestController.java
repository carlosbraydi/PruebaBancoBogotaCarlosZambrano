package com.pruebabancobogota.test;

import com.pruebabancobogota.prueba.controller.EmployeeController;
import com.pruebabancobogota.prueba.model.Employee;
import com.pruebabancobogota.prueba.service.IEmployeeService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.lenient;
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
    public void givenDTOIsValid_whenCallController_thenReturnEmployees() {
        List<Employee> listEmployees = new ArrayList<>();
        listEmployees.add(new Employee(1,"carlos","developer"));
        lenient().when(controller.getEmployees()).thenReturn(listEmployees);
    }
}
