package com.computeiros.reciclagus.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "collect_point")
public class CollectionPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "host_id", referencedColumnName = "id")
    private Company host;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "collect_point_trash",
            joinColumns = @JoinColumn(name = "collect_point_id"),
            inverseJoinColumns = @JoinColumn(name = "trash_id")
    )
    @Column(nullable = false)
    private Set<Trash> trashes = new HashSet<Trash>();

    public CollectionPoint(){
        address = new Address();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Company getHost() {
        return host;
    }

    public void setHost(Company host) {
        this.host = host;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Trash> getTrashes() {
        return trashes;
    }

    public void setTrashes(Set<Trash> trashes) {
        this.trashes = trashes;
    }
}
