package com.computeiros.reciclagus.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Trash")
public class Trash {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String type;
    @ManyToMany(mappedBy = "targets")
    @JsonIgnore
    private Set<CollectionCompany> companies = new HashSet<CollectionCompany>();

    @ManyToMany(mappedBy = "trashes")
    @JsonIgnore
    private Set<CollectionPoint> collPoints = new HashSet<CollectionPoint>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<CollectionCompany> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<CollectionCompany> companies) {
        this.companies = companies;
    }

    public Set<CollectionPoint> getCollPoints() {
        return collPoints;
    }

    public void setCollPoints(Set<CollectionPoint> collPoints) {
        this.collPoints = collPoints;
    }
}
