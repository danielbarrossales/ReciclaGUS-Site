package com.computeiros.reciclagus.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "trash")
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
    private Set<CollectPoint> collPoints = new HashSet<CollectPoint>();

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

    public Set<CollectPoint> getCollPoints() {
        return collPoints;
    }

    public void setCollPoints(Set<CollectPoint> collPoints) {
        this.collPoints = collPoints;
    }
}
