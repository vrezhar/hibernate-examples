package com.example.inheritance.single;

import com.example.inheritance.AbstractImmutableEntity;

import javax.persistence.*;

@Entity
@Table(name = "pokemon")
@DiscriminatorValue("null")
@DiscriminatorColumn(name = "type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Pokemon extends AbstractImmutableEntity {
    private String name;
    private Integer health;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public void fight(Pokemon pokemon) {

    }
}
