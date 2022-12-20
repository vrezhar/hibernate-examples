package com.example.inheritance.single;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("WATER")
public class WaterTypePokemon extends Pokemon {
}
