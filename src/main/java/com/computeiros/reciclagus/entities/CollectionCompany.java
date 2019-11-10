package com.computeiros.reciclagus.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "collection_company")
public class CollectionCompany extends Company {
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "collection_company_trash",
            joinColumns = @JoinColumn(name = "collection_company_id"),
            inverseJoinColumns = @JoinColumn(name = "trash_id")
    )
    @JsonIgnore
    @Column(nullable = false)
    private Set<Trash> targets = new HashSet<Trash>();

    public Set<Trash> getTargets() {
        return targets;
    }

    public void setTargets(Set<Trash> targets) {
        this.targets = targets;
    }
}
