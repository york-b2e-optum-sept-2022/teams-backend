package net.yorksolutions.teams.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "account", orphanRemoval = true)
    private Address address;

    public Account() {
    }

    public Account(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Set<Team> getOwnedTeams() {
//        return ownedTeams;
//    }
//
//    public void setOwnedTeams(Set<Team> ownedTeams) {
//        this.ownedTeams = ownedTeams;
//    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
