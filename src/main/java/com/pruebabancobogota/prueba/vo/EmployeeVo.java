package com.pruebabancobogota.prueba.vo;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class EmployeeVo {

    @NotNull
    private Integer idEmployee;

    @NotNull
    private String fullName;

    @NotNull
    private String function;

    private List<Integer> employees;
    private Integer boss;
}
