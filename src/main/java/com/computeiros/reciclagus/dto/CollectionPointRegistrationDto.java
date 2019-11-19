package com.computeiros.reciclagus.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CollectionPointRegistrationDto {
    @NotEmpty
    private String state;
    @NotEmpty
    private String city;
    @NotEmpty
    private String neighborhood;
    @NotEmpty
    private String street;

    private int number;
    @NotEmpty
    private String complement;

    private Integer id;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
