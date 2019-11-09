package com.computeiros.reciclagus.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "trash")
public class Trash {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String tipo;
    @ManyToMany(mappedBy = "targets")
    private Set<CollectionCompany> companies = new HashSet<CollectionCompany>();

    @ManyToMany(mappedBy = "trashes")
    private Set<CollectPoint> collPoints = new HashSet<CollectPoint>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Set<CollectionCompany> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<CollectionCompany> companies) {
        this.companies = companies;
    }

    public Set<CollectPoint> getCollPoints() {
        return collPoints;
    }

    public void setCollPoints(Set<CollectPoint> collPoints) {
        this.collPoints = collPoints;
    }
}
