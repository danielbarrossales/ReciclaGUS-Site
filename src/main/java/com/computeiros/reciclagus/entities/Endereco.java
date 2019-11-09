package com.computeiros.reciclagus.entities;


import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String estado;
    private String cidade;
    private String rua;
    private Integer numero;
    private String complemento;

    public Endereco() {
    }

    public Endereco(Integer id, String estado, String cidade, String rua, Integer numero, String complemento) {
        this.setId(id);
        this.setEstado(estado);
        this.setCidade(cidade);
        this.setRua(rua);
        this.setNumero(numero);
        this.setComplemento(complemento);
    }

    public Endereco(String estado, String cidade, String rua, Integer numero, String complemento) {
        this.setId(id);
        this.setEstado(estado);
        this.setCidade(cidade);
        this.setRua(rua);
        this.setNumero(numero);
        this.setComplemento(complemento);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
