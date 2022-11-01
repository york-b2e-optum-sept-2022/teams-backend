package net.yorksolutions.teams.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String name;

    @ManyToOne
    Account owner;


    public Team() {}
    public Team(String name, Account owner) {
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }
}
