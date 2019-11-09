package com.computeiros.reciclagus.entities;

import javax.persistence.*;


@Entity
@Table(name = "telefone")
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer ddd;
    private Long numero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id")

    private Empresa empresa;

    public Telefone() {
    }

    public Telefone(Integer id, Integer ddd, Long numero) {
        this.setId(id);
        this.setDdd(ddd);
        this.setNumero(numero);
    }

    public Telefone(Integer ddd, Long numero) {
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
