package com.computeiros.reciclagus.dto;

import javax.validation.constraints.NotEmpty;

public class CompanyRegistrationDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String cnpj;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String state;
    @NotEmpty
    private String city;
    @NotEmpty
    private String neighborhood;
    @NotEmpty
    private String street;
    @NotEmpty
    private long number;
    @NotEmpty
    private String complement;
}
