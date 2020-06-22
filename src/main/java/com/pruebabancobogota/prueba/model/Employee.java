package com.pruebabancobogota.prueba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    public Employee(Integer idEmployee, String fullName, String function) {
        this.idEmployee = idEmployee;
        this.fullName = fullName;
        this.function = function;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmployee;

    @Column()
    private String fullName;

    @Column()
    private String function;

    @OneToMany(
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private List<Employee> employees;

    @OneToOne(optional = true, cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Employee boss;
}
