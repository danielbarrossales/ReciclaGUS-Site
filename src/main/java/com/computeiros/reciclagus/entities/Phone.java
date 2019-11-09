package com.computeiros.reciclagus.entities;

import javax.persistence.*;


@Entity
@Table(name = "phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer ddd;
    private Long numero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    public Phone() {
    }

    public Phone(Integer id, Integer ddd, Long numero) {
        this.setId(id);
        this.setDdd(ddd);
        this.setNumero(numero);
    }

    public Phone(Integer ddd, Long numero) {
        this.setId(id);
        this.setDdd(ddd);
        this.setNumero(numero);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
