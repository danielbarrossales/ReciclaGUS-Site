package com.computeiros.reciclagus.models;


import javax.persistence.*;

@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String neighborhood;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private Integer number;
    @Column(nullable = false)
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

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}
