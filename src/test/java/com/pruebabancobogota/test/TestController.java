package com.pruebabancobogota.test;

import com.pruebabancobogota.prueba.controller.EmployeeController;
import com.pruebabancobogota.prueba.model.Employee;
import com.pruebabancobogota.prueba.service.IEmployeeService;
import com.pruebabancobogota.prueba.vo.EmployeeVo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

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
    public void given_whenGetEmployees_thenReturnEMployees() {
        List<Employee> employess = new ArrayList<>();
        employess.add(new Employee(1, "carlos zambrano", "Developer"));
        when(service.getEmployees()).thenReturn(employess);
        List<Employee> list = controller.getEmployees();
        Assert.assertEquals(list.size(), employess.size());

    }
}
