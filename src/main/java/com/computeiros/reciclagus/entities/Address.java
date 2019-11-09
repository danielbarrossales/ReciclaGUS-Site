package com.computeiros.reciclagus.entities;


import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String state;
    private String city;
    private String street;
    private Integer number;
    private String complement;

    public Address() {
    }

    public Address(Integer id, String state, String city, String street, Integer number, String complement) {
        this.setId(id);
        this.setState(state);
        this.setCity(city);
        this.setStreet(street);
        this.setNumber(number);
        this.setComplement(complement);
    }

    public Address(String state, String city, String street, Integer number, String complement) {
        this.setId(id);
        this.setState(state);
        this.setCity(city);
        this.setStreet(street);
        this.setNumber(number);
        this.setComplement(complement);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}
