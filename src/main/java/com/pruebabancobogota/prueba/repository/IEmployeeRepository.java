package com.pruebabancobogota.prueba.repository;

import com.pruebabancobogota.prueba.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("select new Employee(idEmployee, fullName, function) from Employee where boss.idEmployee = :idEmployee")
    List<Employee> getEmployeeById(@Param("idEmployee") Integer idEmployee);
}
